<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="css/shop/user.css">
<!-- Header Area -->
<header class="header_area">
	<script src="js/jquery.min.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
  	<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
  	
  	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  
<script type="text/javascript">

const Toast2 = Swal.mixin({
    toast: true,
    position: 'center-center',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: function(toast) {
      toast.addEventListener('mouseenter', Swal.stopTimer)
      toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
});
////////////////////
// 쿠키 저장
	function setCookie(name, value, days) {
	  var expires = "";
	  if (days) {
	    var date = new Date();
	    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
	    expires = "; expires=" + date.toUTCString();
	  }
	  document.cookie = name + "=" + value + expires + "; path=/";
	}

	// 쿠키 읽기
	function getCookie(name) {
	  var nameEQ = name + "=";
	  var ca = document.cookie.split(';');
	  for (var i = 0; i < ca.length; i++) {
	    var c = ca[i];
	    while (c.charAt(0) == ' ') c = c.substring(1, c.length);
	    if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
	  }
	  return null;
	}

	// 쿠키 삭제
	function deleteCookie(name) {
	  setCookie(name, "", -1);
	}

	

////////////////////







// 로그인 확인
function loginCheck() {
    var luid = $("#luid").val();
    var luPassword = $("#luPassword").val();
    var form = document.user_login_form;
    var rememberMe = $("#rememberId").is(':checked');
    /* 쿠키 저장 */
    if(rememberMe){
    	console.log("기억해줘")
    	var userId =  $("#luid").val();
	    setCookie("rememberedId", userId, 7); // 7일 동안 쿠키 저장
	  } else {
	    deleteCookie("rememberedId");
	  }

    if ($("#luid").val() == "admin") {
        Swal.fire({
            icon: 'warning',
            title: "관리자 로그인 접근 감지! \n 관리자가 아닐 경우 법적 처벌을 받을 수 있습니다. \n 그래도 접근하시겠습니까?",
            showCancelButton: true,
            confirmButtonText: "접근",
            cancelButtonText: "취소"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: 'admin_login',
                    data: {
                        aid: luid,
                        aPassword: luPassword
                    },
                    success: function(result) {
                        console.log(result);
                        if (result == 0) {
                            Swal.fire({
                                icon: 'warning',
                                title: "ID 혹은 비밀번호를 확인해주세요."
                            });
                            return;
                        }

                        if (result == 1) {
                            Swal.fire({
                                icon: 'success',
                                title: "로그인 성공! \n 관리자님 오늘도 화이팅입니다."
                            }).then(() => {
                                $("#user_login_form").attr("action", "index");
                                $("#user_login_form").submit();
                            });
                        }
                    },
                    error: function() {
                        Swal.fire({
                            icon: 'warning',
                            title: "오류가 발생했습니다. 관리자에게 문의해주세요."
                        });
                    }
                });
            }
        });
        return;
    }

    if ($("#luid").val() == "" || $("#luPassword").val() == "") {
        Swal.fire({
            icon: 'warning',
            title: "ID, 비밀번호를 모두 입력해주세요"
        });
        return;
    }

    $.ajax({
        type: 'POST',
        url: '/loginCheck',
        data: {
            uid: luid,
            uPassword: luPassword
        },
        success: function(result) {
            console.log(result);
            if (result == 0) {
                Swal.fire({
                    icon: 'warning',
                    title: "ID 혹은 비밀번호를 확인해주세요."
                });
                return;
            }
            if (result == -1) {
                Swal.fire({
                    icon: 'warning',
                    title: "탈퇴한 회원입니다."
                });
                return;
            }
            if (result == -2) {
                Swal.fire({
                    icon: 'warning',
                    title: "존재하지 않는 회원입니다."
                });
                return;
            }
            if (result == 1) {
                Swal.fire({
                    icon: 'success',
                    title: "로그인 성공! \n 환영합니다."
                }).then(() => {
                    $("#user_login_form").submit();
                });
            }
        },
        error: function() {
            Swal.fire({
                icon: 'warning',
                title: "오류가 발생했습니다. 관리자에게 문의해주세요."
            });
        }
    });
}


function emptySessionUser() {
    Swal.fire({
        icon: 'question',
        title: "로그인이 필요한 페이지입니다.\n 로그인 하시겠습니까?",
        showCancelButton: true,
        confirmButtonText: "로그인",
        cancelButtonText: "취소"
    }).then((result) => {
        if (result.isConfirmed) {
            openLoginModal();
        }
    });
}
	
	
	// 회원가입 모달 열기
	function openSignUpModal(uEmail, uNickName, uBirthday) {
		$('#ruEmail').val(uEmail);
		$('#ruNickName').val(uNickName);
		$('#ruBirthday').val(uBirthday);
		
		$('#loginModal').modal('hide');
		$('#signUpModal').modal('show');
		$('#rcancelBtn').off('click').on('click', function() {
			$('#signUpModal').modal('hide');
		});
		$('#rcloseBtn').off('click').on('click', function() {
			$('#signUpModal').modal('hide');
		});
		// 모달 외부 클릭 시 닫기
		window.onclick = function(event) {
			var modal = document.getElementById("signUpModal");
			if (event.target == modal) {
				$('#signUpModal').modal('hide');
			}
		}
	}
	
	function openLoginModal() {
		  var rememberedId = getCookie("rememberedId");
		  console.log("쿠키 아이디 : " + rememberedId)
		  if (rememberedId) {
		    $('#luid').val(rememberedId);
		    document.getElementById("rememberId").checked = true;
		  }
		$('#loginModal').modal('show');
		$('#cancelBtn').off('click').on('click', function() {
			$('#loginModal').modal('hide');
		});
		$('#closeBtn').off('click').on('click', function() {
			$('#loginModal').modal('hide');
		});
	}
	
	// 모달 외부 클릭 시 닫기
	window.onclick = function(event) {
		var modal = document.getElementById("loginModal");
		if (event.target == modal) {
			$('#loginModal').modal('hide');
		}
	};
	
	// 아이디 중복 체크
	function checkDuplicateId() {
	    const ruid = $('#ruid').val();
	    var regExpuid = /^[a-z|A-Z|0-9]*$/;
	    const regExpAdmin = /^(?!.*(?:admin|root|insert|update|delete|select)).*$/
	    if (!regExpAdmin.test(ruid.toLowerCase())) {
	        Swal.fire({
	            icon: 'warning',
	            title: "해당 아이디는 사용 불가능합니다."
	        });
	        form.ruid.select();
	        return;
	    }
	    if (ruid.trim().length === 0) {
	        Swal.fire({
	            icon: 'warning',
	            title: "아이디를 입력해주세요."
	        });
	        return;
	    }
	    if (!regExpuid.test(ruid)) {
	        Swal.fire({
	            icon: 'warning',
	            title: "아이디는 영문&숫자만 사용 가능합니다."
	        });
	        form.ruid.select();
	        return;
	    }
	    console.log(ruid);
	    $.ajax({
	        type: 'GET',
	        url: 'checkDuplicateId',
	        data: {
	            uid: ruid
	        },
	        success: function(result) {
	            console.log(result);
	            if (result == 0) {
	                Swal.fire({
	                    icon: 'warning',
	                    title: "사용 가능한 아이디입니다."
	                });
	            } else {
	                Swal.fire({
	                    icon: 'warning',
	                    title: "중복되는 아이디입니다."
	                });
	            }
	        },
	        error: function() {
	            Swal.fire({
	                icon: 'warning',
	                title: "오류가 발생했습니다. 다시 시도해주세요."
	            });
	        }
	    });
	}
	
	// 이메일 중복 체크
	function checkDuplicateEmail() {
	    const ruEmail = $('#ruEmail').val();
	    const regExpuEmail = /^\w+@[a-zA-Z_]+?\.(com|co\.kr|net)$/;
	    if (!regExpuEmail.test(ruEmail.toLowerCase())) {
	        Swal.fire({
	            icon: 'warning',
	            title: "해당 이메일은 사용 불가능합니다."
	        });
	        hideMailCheckDiv();
	        form.ruid.select();
	        return;
	    }
	    if (ruEmail.trim().length === 0) {
	        Swal.fire({
	            icon: 'warning',
	            title: "이메일을 입력해주세요."
	        });
	        hideMailCheckDiv();
	        return;
	    }
	    console.log(ruid);
	    $.ajax({
	        type: 'GET',
	        url: 'checkDuplicateEmail',
	        data: {
	            uEmail : ruEmail
	        },
	        success: function(result) {
	            console.log(result);
	            if (result === 0) {
	                Swal.fire({
	                  icon: 'success',
	                  title: "사용 가능한 이메일입니다.",
	                  text: "잠시 후 인증번호가 발송됩니다."
	                }).then(function() {
                		showMailCheckDiv();
                		mailCheck();
	                });
	              } else {
	                Swal.fire({
	                    icon: 'warning',
	                    title: "중복되는 이메일입니다."
	                });
	                hideMailCheckDiv();
	            }
	        },
	        error: function() {
	            Swal.fire({
	                icon: 'warning',
	                title: "오류가 발생했습니다. 다시 시도해주세요."
	            });
	        }
	    });
	}

	
	
	/* 회원가입 체크 */
	function registerCheck() {
	    const form = document.user_register_form;
	    const ruid = $('#ruid').val();
	    const ruPassword = $('#ruPassword').val();
	    const ruRePass = $('#ruRePass').val();
	    const ruName = $('#ruName').val();
	    const ruNickName = $('#ruNickName').val();
	    const ruPhone1 = $('#ruPhone1').val();
	    const ruPhone2 = $('#ruPhone2').val();
	    const ruPhone3 = $('#ruPhone3').val();
	    const ruPhone = ruPhone1 + '-' + ruPhone2 + '-' + ruPhone3;
	    const ruEmail = $('#ruEmail').val();
	    const ruAddress = $('#ruAddress').val();
	    const ruDetailAddress = $('#ruDetailAddress').val();
	    const ruGender = $('input[name="gender"]:checked').val();
	    const ruBirthday = $('#ruBirthday').val();
	    const ruZipcode = $('#ruZipcode').val();
	    const regExpAdmin = /^(?!.*(?:admin|root|insert|update|delete|select)).*$/;
	    const regExpuid = /^[a-z|A-Z|0-9]*$/;
	    const regExpuPass = /^[a-z|A-Z|0-9]*$/;
	    const regExpuName = /^[a-z|A-Z|가-힣]*$/;
	    const regExpuNickName = /^[a-z|A-Z|가-힣]*$/;
	    const regExpuPhone = /^\d{3}-\d{3,4}-\d{4}$/;
	    const regExpuPhone2 = /^[0-9]*$/;
	    const regExpuEmail = /^\w+@[a-zA-Z_]+?\.(com|co\.kr|net)$/;
	    const regExpuAddress = /^[가-힣|0-9|a-z|A-Z|-|\s]*$/;

	    /* Admin등 아이디 유효성 검사*/
	    if (!regExpAdmin.test(ruid.toLowerCase())) {
	        Swal.fire({
	            icon: 'warning',
	            title: "해당 아이디는 사용 불가능합니다."
	        });
	        form.ruid.select();
	        return;
	    }

	    /* ID 입력 확인 */
	    if (ruid.trim().length === 0) {
	        Swal.fire({
	            icon: 'warning',
	            title: "아이디를 입력해주세요."
	        });
	        return;
	    }
	    if (!regExpuid.test(ruid)) {
	        Swal.fire({
	            icon: 'warning',
	            title: "아이디는 영문&숫자만 사용 가능합니다."
	        });
	        form.ruid.select();
	        return;
	    }

	    /* 비밀번호 입력 확인 */
	    if (ruPassword.trim().length === 0) {
	        Swal.fire({
	            icon: 'warning',
	            title: "비밀번호를 입력해주세요."
	        });
	        return;
	    }
	    if (!regExpuPass.test(ruPassword)) {
	        Swal.fire({
	            icon: 'warning',
	            title: "비밀번호는 영문&숫자만 사용 가능합니다."
	        });
	        form.ruPassword.select();
	        return;
	    }
	    if (ruRePass.trim().length === 0) {
	        Swal.fire({
	            icon: 'warning',
	            title: "비밀번호 확인을 입력해주세요."
	        });
	        return;
	    }
	    if (!regExpuPass.test(ruRePass)) {
	        Swal.fire({
	            icon: 'warning',
	            title: "비밀번호는 영문&숫자만 사용 가능합니다."
	        });
	        form.ruRePass.select();
	        return;
	    }
	    if (ruPassword.trim() !== ruRePass.trim()) {
	        Swal.fire({
	            icon: 'warning',
	            title: "비밀번호가 일치하지 않습니다."
	        });
	        form.ruRePass.select();
	        return;
	    }

	    /* 이름, 닉네임 입력 확인 */
	    if (ruName.trim().length === 0) {
	        Swal.fire({ icon: 'warning', title: "이름을 입력해주세요."});
	        form.ruName.focus();
	        return;
	    }
	    if (ruNickName.trim().length === 0) {
	        Swal.fire({ icon: 'warning', title: "닉네임을 입력해주세요."});
	        form.ruNickName.focus();
	        return;
	    }
	    if (!regExpuName.test(ruName)) {
	        Swal.fire({
	            icon: 'warning',
	            title: "이름은 한글과 영문만 입력 할 수 있습니다."
	        });
	        form.ruName.select();
	        return;
	    }
	    if (!regExpuNickName.test(ruNickName)) {
	        Swal.fire({
	            icon: 'warning',
	            title: "닉네임은 한글과 영문만 입력 할 수 있습니다."
	        });
	        form.ruNickName.select();
	        return;
	    }

	    /* 생일 입력 확인 */
	    if (ruBirthday.length === 0) {
	        Swal.fire({ icon: 'warning', title: "생일을 선택해주세요."});
	        return;
	    }

	    /* 전화번호 입력 확인 */
	    if (ruPhone2.trim().length === 0) {
	        Swal.fire({
	            icon: 'warning',
	            title: "전화번호를 입력해주세요."
	        });
	        return;
	    }
	    if (ruPhone3.trim().length === 0) {
	        Swal.fire({
	            icon: 'warning',
	            title: "전화번호를 입력해주세요."
	        });
	        return;
	    }
	    if (!regExpuPhone2.test(ruPhone2)) {
	        Swal.fire({ icon: 'warning', title: "전화번호는 숫자만 가능합니다."});
	        form.ruPhone2.select();
	        return;
	    }
	    if (!regExpuPhone2.test(ruPhone3)) {
	        Swal.fire({ icon: 'warning', title: "전화번호는 숫자만 가능합니다."});
	        form.ruPhone3.select();
	        return;
	    }
	    if (!regExpuPhone.test(ruPhone)) {
	        Swal.fire({ icon: 'warning', title: "전화번호를 확인해주세요."});
	        form.ruPhone.select();
	        return;
	    }

	    if (ruEmail.trim().length === 0) {
	        Swal.fire({ icon: 'warning', title: "이메일을 입력해주세요."});
	        return;
	    }
	    if (!regExpuEmail.test(ruEmail)) {
	        Swal.fire({ icon: 'warning', title: "이메일 형식을 확인해주세요. \n ex) id@domain.com"});
	        ruEmail.select();
	        return;
	    }

	    if (ruAddress.trim().length === 0) {
	        Swal.fire({ icon: 'warning', title: "주소를 입력해주세요."});
	        return;
	    }
	    if (ruDetailAddress.trim().length === 0) {
	        Swal.fire({ icon: 'warning', title: "상세 주소를 입력해주세요."});
	        return;
	    }
	    if (ruZipcode.length === 0) {
	        Swal.fire({ icon: 'warning', title: "우편번호를 입력해주세요."});
	        return;
	    }
	    if (!regExpuAddress.test(ruDetailAddress)) {
	        Swal.fire({ icon: 'warning', title: "주소는 영문/한글/숫자/- 만 입력 가능합니다."});
	        ruAddress.select();
	        return;
	    }
	    console.log(ruid);
	    $.ajax({
	        type: 'POST',
	        url: 'sign_up',
	        data: {
	            uid: ruid,
	            uPassword: ruPassword,
	            uName: ruName,
	            uNickName: ruNickName,
	            uGender: ruGender,
	            uBirthday: ruBirthday,
	            uPhone: ruPhone,
	            uEmail: ruEmail,
	            uaAddress: ruAddress,
	            uaDetailAddress: ruDetailAddress,
	            uaZipcode: ruZipcode
	        },
	        success: function(result) {
	            console.log(result);
	            if (result == 1) {
	                Swal.fire({
	                    icon: 'question',
	                    title: "회원가입을 축하합니다! \n바로 로그인 하시겠습니까?"
	                }).then((result) => {
	                    if (result.isConfirmed) {
	                        $('#signUpModal').modal('hide');
	                        openLoginModal();
	                    }
	                });
	            } else {
	                Swal.fire({ icon: 'warning', title: "회원 가입에 실패했습니다. 중복을 확인해주세요."});
	                return;
	            }
	        },
	        error: function() {
	            Swal.fire({ icon: 'warning', title: "오류가 발생했습니다. 관리자에게 문의해주세요."});
	        }
	    });
	}

	document.addEventListener("DOMContentLoaded", function() {
	    var passwordInput = document.getElementById("ruPassword");
	    var confirmPasswordInput = document.getElementById("ruRePass");

	    confirmPasswordInput.addEventListener("input", confirmPasswordMatch);

	    function confirmPasswordMatch() {
	        var password = document.getElementById("ruPassword").value;
	        var confirmPassword = document.getElementById("ruRePass").value;
	        var passwordMatchEl = document.getElementById("passwordConfirm");

	        if (password === confirmPassword) {
	            passwordMatchEl.textContent = "Password Match";
	            passwordMatchEl.style.color = "green";
	        } else {
	            passwordMatchEl.textContent = "Password Mismatch";
	            passwordMatchEl.style.color = "red";
	        }
	    }
	});


//f544dc7ed174c1cb80376d3cee1683f2
// REST API : dd7da6e9a1d0fbb61bee671f56f3ddd4
// JavaScript키 :f544dc7ed174c1cb80376d3cee1683f2
//window.Kakao.init("f544dc7ed174c1cb80376d3cee1683f2");
//rKakao.init('f544dc7ed174c1cb80376d3cee1683f2');
	
	function kakao_login() {
		Kakao.init('f544dc7ed174c1cb80376d3cee1683f2');
		// 카카오 로그인 서비스 실행하기 및 사용자 정보 가져오기.
		Kakao.Auth.login({
			success: function(auth) {
				Kakao.API.request({
					url: '/v2/user/me',
					success: function(response) {
						// 사용자 정보를 가져와서 폼에 추가.
						var account = response.kakao_account;
						var uEmail = account.email;
						var uNickName = account.profile.nickname;
						var uGender = account.gender;
						var uBirthday = account.birthday;
						var uImg = account.profile.img;
						var access_token = auth.access_token;
						/* alert(JSON.stringify(auth)); */
						console.log("access_token : " + access_token)

						$('#form-kakao-login input[name=email]').val(uEmail);
						$('#form-kakao-login input[name=name]').val(uNickName);
						$('#form-kakao-login input[name=img]').val(uImg);
						// 사용자 정보가 포함된 폼을 서버로 제출한다.
						/* document.querySelector('#form-kakao-login').submit(); */

						$.ajax({
							  type: "POST",
							  url: 'kakao_login',
							  data: {
							    uEmail: uEmail,
							    uNickName: uNickName,
							    uImg: uImg,
							    access_token : access_token
							  },
							  success: function(result) {
							    console.log("카카오 로그인 결과 : " + result);
							    if (result == 0) {
							      Swal.fire({
							        icon: 'warning',
							        title: "존재하지 않는 아이디입니다.",
							        text: "회원가입 하시겠습니까?",
							        showCancelButton: true,
							        confirmButtonText: "OK",
							        cancelButtonText: "NO"
							      }).then((result) => {
							        if (result.isConfirmed) {
							          $('#ruEmail').prop('readonly', true);
							          openSignUpModal(uEmail, uNickName, uBirthday);
							        }
							      });
							    } else if (result == -1) {
							      Swal.fire({
							        icon: 'warning',
							        title: "탈퇴한 회원입니다."
							      });
							    } else if (result == 1) {
							      $('#loginModal').modal('hide');
							      Swal.fire({
							        icon: 'success',
							        title: "로그인 성공!"
							      }).then(() => {
							        // user_login_form의 action 속성을 "index"로 변경
							        $('#user_login_form').attr('action', 'index');
							        // 폼 제출
							        $('#user_login_form').submit();
							      });
							    }
							  }
							});
					},
				}); // api request
			}, // success 결과.
			fail: function(error) {
				// 경고창에 에러메시지 표시
				Swal.fire({ icon: 'warning', title: "카카오 로그인에 실패했습니다."});
			}
		}); // 로그인 인증.
	}

	
    function kakao_logout() {
        if (!Kakao.Auth.getAccessToken()) {
            alert('Not logged in.');
            return;
        }
        Kakao.Auth.logout(function() {
            alert('logout ok\naccess token -> ' + Kakao.Auth.getAccessToken());
        });
    }
    
    
    var code;
    function mailCheck() {
		const email = $('#ruEmail').val() // 이메일 주소값 얻어오기!
		console.log('완성된 이메일 : ' + email); // 이메일 오는지 확인
		const checkInput = $('.mail-check-input') // 인증번호 입력하는곳 
		$.ajax({
			type : 'post',
			url : 'mailCheck',
			data: {
			    email : email
			  },
			success : function (data) {
				console.log("data : " +  data);
				checkInput.attr('disabled',false);
				code = data;
				Toast2.fire({
				    icon: 'success',
				    title: '인증번호가 전송되었습니다.',
				    timerProgressBar: true,
				    timer: 3000, // 3초 후에 자동으로 사라짐
				    showConfirmButton: false
				});
				startTimer()
			}			
		}); // end ajax
	} // end send eamil
	
	function showMailCheckDiv() {
		  var mailCheckDiv = document.querySelector('.mail-check-box');
		  var mailCheckInput = document.querySelector('.mail-check-input');

		  mailCheckDiv.style.display = 'block';
		  mailCheckInput.disabled = false;
		}

		function hideMailCheckDiv() {
		  var mailCheckDiv = document.querySelector('.mail-check-box');
		  var mailCheckInput = document.querySelector('.mail-check-input');

		  mailCheckDiv.style.display = 'none';
		  mailCheckInput.disabled = true;
		}

	
	// 인증번호 비교 
	function codeCheck(){
	    const inputCode = $('#confirmCode').val();
	    const $resultMsg = $('#mail-check-warn');
	    if (inputCode === code) {
	    	 Swal.fire({
	             icon: 'success',
	             title: '인증번호가 일치합니다!',
	             confirmButtonText: 'OK',
	         });
	    	clearInterval(timerInterval);
	    	document.getElementById('timer').style.display = 'none';
         	$('#registerBtn').prop('disabled', false);
		    $('#confirmCode').prop('readonly', true);
	        $('#mail-Check-Btn').attr('disabled', true);
	        $('#ruEmail').attr('readonly', true);
	    } else {
         	$('#registerBtn').prop('disabled', true);
         	Swal.fire({
	             icon: 'warning',
	             title: '인증번호가 일치 하지 않습니다.',
	             text: '인증번호를 확인 해주세요.',
	             confirmButtonText: 'OK'
	         });
	    }
	}

	let minutesRemaining = 0;
	let secondsRemaining = 5;
	let timerInterval;

	function startTimer() {
	  timerInterval = setInterval(updateTimer, 1000);
	}


	function updateTimer() {
	  document.getElementById('minutes').textContent = "남은 시간 : " + minutesRemaining.toString().padStart(2, '0') + "분 ";
	  document.getElementById('seconds').textContent = secondsRemaining.toString().padStart(2, '0') + "초";

	  if (minutesRemaining > 0 || secondsRemaining > 0) {
	    if (secondsRemaining > 0) {
	      secondsRemaining--;
	    } else {
	      minutesRemaining--;
	      secondsRemaining = 59;
	    }
	  } else {
	    // Swal 창을 한 번만 표시하고 타이머를 멈추도록 수정
        clearInterval(timerInterval); // 타이머 인터벌 멈추기
        document.getElementById('mail-check-box').style.display = 'none';
	    Swal.fire({
	      icon: 'warning',
	      title: '제한 시간 초과',
	      text: '이메일 인증을 다시 시도해주세요.',
	      confirmButtonText: '확인',
	    });
	    return;
	  }
	}
	
	
	
	
</script>



	<!-- Top Header Area -->
	<div class="top-header-area">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-6">
					<div class="welcome-note">
						<span class="popover--text" data-toggle="popover"
							data-content="Welcome to Bigshop ecommerce template."><i
							class="icofont-info-square"></i></span> <span class="text">Tent
							Shop에 오신 걸 환영합니다.</span>
					</div>
				</div>
				<div class="col-6">
					<div
						class="language-currency-dropdown d-flex align-items-center justify-content-end">
						<!-- <!-- Language Dropdown
						<div class="language-dropdown">
							<div class="dropdown">
								<a class="btn btn-sm dropdown-toggle" href="#" role="button"
									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> English </a>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="dropdownMenu1">
									<a class="dropdown-item" href="#">Bangla</a> <a
										class="dropdown-item" href="#">Arabic</a>
								</div>
							</div>
						</div>
						<!-- <!-- Currency Dropdown
						<div class="currency-dropdown">
							<div class="dropdown">
								<a class="btn btn-sm dropdown-toggle" href="#" role="button"
									id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> $ USD </a>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="dropdownMenu2">
									<a class="dropdown-item" href="#">à§³ BDT</a> <a
										class="dropdown-item" href="#">â¬ Euro</a>
								</div>
							</div>
						</div> -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Main Menu -->
	<div class="bigshop-main-menu">
		<div class="container">
			<div class="classy-nav-container breakpoint-off">
				<nav class="classy-navbar" id="bigshopNav">

					<!-- Nav Brand -->
					<a href="index" class="nav-brand"> <img
						src="img/core-img/logo.png" alt="logo" id="logo_img"
						style="width: 220px; height: 50px;">
					</a>

					<!-- Toggler -->
					<div class="classy-navbar-toggler">
						<span class="navbarToggler"><span></span><span></span><span></span></span>
					</div>

					<!-- Menu -->
					<div class="classy-menu">
						<!-- Close -->
						<div class="classycloseIcon">
							<div class="cross-wrap">
								<span class="top"></span><span class="bottom"></span>
							</div>
						</div>

						<!-- Nav -->
						<div class="classynav">
							<ul>
								<li><a href="index">Home</a></li>
								<c:if test="${empty SUID}">
									<li><a href="product_list" id="shop_main_menu">Shop</a></li>
									<li><a href="notice_list">Notice</a></li>
									<li><a onclick="emptySessionUser()">Orders</a></li>
									<li><a onclick="emptySessionUser()">QNA</a></li>
									<li><a onclick="emptySessionUser()">Board</a></li>
								</c:if>
								<c:if test="${!empty SUID}">
									<li><a href="product_list" id="shop_main_menu">Shop</a></li>
									<li><a href="notice_list">Notice</a></li>
									<li><a href="purchase_list">Orders</a></li>
									<li><a href="question_list">QNA</a></li>
									<li><a href="board_list">Board</a></li>
								</c:if>
							</ul>
						</div>
					</div>

					<!-- Hero Meta -->
					<div class="hero_meta_area ml-auto d-flex align-items-center justify-content-end">
						<!-- Search -->
						<div class="search-area">
							<div class="search-btn">
								<i class="icofont-search"></i>
							</div>
							<!-- Form -->
							<div class="search-form">
								<form action="product_list" method="post">
									<input type="search" class="form-control" name="query" placeholder="Search">
									<input type="submit" class="d-none" value="Send">
								</form>
							</div>
						</div>

						<!-- Wishlist -->
						<div class="wishlist-area">
							<c:if test="${empty SUID}">
								<a onclick="emptySessionUser()" class="wishlist-btn"><i
									class="icofont-heart"></i></a>
							</c:if>
							<c:if test="${!empty SUID}">
								<a href="wishlistselect" class="wishlist-btn"><i
									class="icofont-heart"></i></a>
							</c:if>
						</div>

						<!-- Cart -->

						<div class="cart-area">
							<div class="cart--btn">
								<c:if test="${empty SUID}">
									<a onclick="emptySessionUser()"><i class="icofont-cart"></i></a>
								</c:if>
								<c:if test="${!empty SUID}">
									<a href="cart_list"><i class="icofont-cart"></i><span
										class="cart_quantity">${cartList.size()}</span></a>
								</c:if>
							</div>

							<!-- Cart Dropdown Content -->
							<c:if test="${!empty SUID}">
								<div class="cart-dropdown-content">
									<ul class="cart-list">
										<c:set var="tot_price" value="0" />
										<c:forEach var="cart" items="${cartList}">
											<c:set var="tot_price"
												value="${tot_price + cart.product.p_price * cart.c_qty}" />
											<li id="header_cart_item_${cart.c_no}">
												<div class="cart-item-desc">
													<a href="product_detail?p_no=${cart.product.p_no}"
														class="image"> <img
														src="img/p_img/${cart.product.imageList[0].im_name}"
														class="cart-thumb" alt="">
													</a>
													<div>
														<a href="product_detail?p_no=${cart.product.p_no}">${cart.product.p_name}</a>
														<p>
															<c:set var="item_total"
																value="${cart.c_qty * cart.product.p_price}" />
															${cart.c_qty} x - <span class="price">&#8361;<s:eval expression="new java.text.DecimalFormat('#,###').format(item_total)" /></span>
														</p>
													</div>
												</div> <span class="dropdown-product-remove" c_no="${cart.c_no}"><i
													class="icofont-bin"></i></span>
											</li>
										</c:forEach>
									</ul>
									<div class="cart-pricing my-4">
										<ul>
											<li><span>Sub Total:</span> <%-- <span>&#8361;<s:eval expression="new java.text.DecimalFormat('#,##0').format(tot_price)"/></span> --%>
												<span id="header_cart_sub_tot">&#8361;&nbsp;<fmt:formatNumber value="${ITEMTOTAL }" type="number" pattern="#,###"></fmt:formatNumber></span></li>
											<li><span>Shipping:</span> <span id="header_cart_shipping"> 
											<c:set var="shipping" value="${ITEMTOTAL >= 500000 ? 0 : 3000}" />
												&#8361;&nbsp;<fmt:formatNumber value="${shipping}" type="number"></fmt:formatNumber>
											</span></li>
											<c:set var="all_total" value="${ITEMTOTAL*1.1+shipping }" />
											<li><span>Total:</span> 
											<span id="header_cart_tot">&#8361;&nbsp;<fmt:formatNumber value="${ITEMTOTAL*1.1+shipping }" type="number" pattern="#,###"></fmt:formatNumber>
											</span></li>
										</ul>
									</div>
									<div class="cart-box">
										<a href="" id="header_checkout_btn"
											class="btn btn-primary d-block" size="${cartList.size()}">Checkout</a>
										<form id="header_order_create_form" method="post">
											<input type="hidden" name="buyType" value="cart" />
										</form>
									</div>
								</div>
							</c:if>
						</div>

						<!-- Account Start -->
						<div class="account-area">
							<div class="user-thumbnail">
								<c:if test="${empty SUID}">
									<a onclick="emptySessionUser()"> <svg
											xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-person-fill"
											viewBox="0 0 16 16">
										  <path
												d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
									</svg>
									</a>
								</c:if>
								<c:if test="${!empty SUID}">
									<a href="#"><img src="img/bg-img/bono.jpeg" alt=""></a>
								</c:if>
							</div>
							<c:if test="${!empty SUID}">
								<ul class="user-meta-dropdown">
									<li class="user-title"><span>Hello,&nbsp;</span>${SUNICKNAME}😉</li>
									<li><a href="my_account">My Account</a></li>
									<li><a href="purchase_list.do">Orders List</a></li>
									<li><a href="wishlist_view">Wishlist</a></li>
									<li><a href="logout"><i class="icofont-logout"></i>Logout</a></li>
								</ul>
							</c:if>
						</div>
						<!-- Account End -->

					</div>
				</nav>
			</div>
		</div>
	</div>
</header>
<!-- Header Area End -->

<!-- Login Modal -->
<div class="modal" id="loginModal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="container">
				<h5 class="mb-3" style="display: inline-block">Login</h5>
				<span style="color: red">${l_msg}</span>
				<form id="user_login_form" method="post" action="login">
					<div class="form-group">
						<input type="text" class="form-control" id="luid" name="luid"
							placeholder="ID">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="luPassword" name="luPassword" placeholder="Password">
					</div>
					<div class="form-check">
						<div class="custom-control custom-checkbox mb-3 pl-1">
							<!-- 쿠키 저장 여부 -->
							<input type="checkbox" class="custom-control-input" id="rememberId">
							<label class="custom-control-label" for="rememberId">Remember me for this computer</label>
						</div>
					</div>
					<div class="button-container">
						<button type="button" class="btn btn-primary btn-sm" onclick="loginCheck()">Login</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-secondary btn-sm" id="cancelBtn" data-dismiss="modal">취소</button>
						<br/>
					</div>
				</form>
				<br/>
				<div class="button-container">
				<input type="image" class="btn btn-light" src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" alt="카카오 로그인" onclick="kakao_login()">
				</div>
				<!-- Forget Password -->
				<div class="forget_pass mt-15" style="text-align: center;"><a href="#">비밀번호를 잊으셨나요?</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" onclick="openSignUpModal()">아직 회원이 아니신가요?</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Login Modal End -->

<!-- signUpModal Start -->
<div class="modal" id="signUpModal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="container">
				<h5 class="mb-3" style="display: inline-block; text-align: center;">SingUp</h5>
				<span style="color: red">${l_msg}</span>
				<form id="user_singUp_form" action="" method="post">
					<div class="form-group">
						  <div class="input-form-group" style="display: flex; align-items: center;">
						  	<input type="text" class="form-control" id="ruid" name="ruid" placeholder="ID">
						    <button type="button" class="btn btn-primary btn-sm" onclick="checkDuplicateId()" style="margin-left: 15px;">Check</button>
						  </div>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="ruPassword" name="ruPassword" placeholder="Password">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="ruRePass" name="ruRePass" placeholder="RePassword">
						<span id="passwordConfirm"></span>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="ruName" name="ruName" placeholder="Name">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="ruNickName" name="ruNickName" placeholder="Nickname">
					</div>
						<input type="radio" name="gender" id="gender-male" value="1" checked="checked"> <label for="gender-male">Male</label>
						<input type="radio" name="gender" id="gender-female" value="2"> <label for="gender-female">Female</label>
					<div class="form-group">
						<input type="date" class="form-control" id="ruBirthday" name="ruBirthday" placeholder="Birthday" min="1900-01-01" max="2010-01-01">
					</div>
					<div class="form-group">
					  <div class="input-form-group" style="display: flex; align-items: center; text-align: center;">
					    <select id="ruPhone1" name="ruPhone1">
					      <option>010</option>
					      <option>011</option>
					      <option>012</option>
					      <option>014</option>
					      <option>017</option>
					    </select>
					    <span style="margin-left: 20px; font-size: 18px;">-</span>
					    <input type="text" class="form-control" id="ruPhone2" name="ruPhone2" placeholder="Phone" style="margin-left: 15px;">
					    <span style="margin-left: 20px; font-size: 18px;">-</span>
					    <input type="text" class="form-control" id="ruPhone3" name="ruPhone3" placeholder="Phone" style="margin-left: 15px;">
					  </div>
					</div>
					<div class="form-group">
						<div class="input-form-group" style="display: flex; align-items: center;">
							<input type="text" class="form-control" id="ruEmail" name="ruEmail" placeholder="ex) Email@domain.com">
							 <button type="button" class="btn btn-primary btn-sm" onclick="checkDuplicateEmail()" style="margin-left: 15px;">Check</button>
						</div>
					</div>
						<div id="mail-check-box" class="mail-check-box" style="display: none;">
							<div class="form-group">
								<div class="input-form-group" style="display: flex; align-items: center;">
									<input id="confirmCode" class="form-control mail-check-input" placeholder="인증번호 6자리를 입력해주세요!" disabled="disabled" maxlength="6">
									<br/>
									<button type="button" class="btn btn-primary btn-sm" id="mail-Check-Btn" onclick="codeCheck()" style="margin-left: 15px;">Confirm</button>
								</div>
								<br/>
								<div id="timer"><span id="minutes"></span><span id="seconds"></span></div>
						</div>
					</div>
					<div class="form-group">
						<div class="input-form-group" style="display: flex; align-items: center;">
							<input type="text" class="form-control address" id="ruAddress" name="ruAddress" placeholder="Address">
							<button type="button" class="btn btn-outline-primary mb-1 searchAddr" style="margin-left: 15px;">search</button>
						</div>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="ruDetailAddress" name="ruDetailAddress" placeholder="Detailed Address">
					</div>
					<div class="form-group">
						<input type="text" class="form-control postcode" id="ruZipcode" name="ruZipcode" placeholder="Zipcode" readonly="readonly">
					</div>
					<div class="button-container">
						<button type="button" id="registerBtn" name="registerBtn" class="btn btn-primary btn-sm" onclick="registerCheck()" disabled="disabled">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-secondary btn-sm" id="rcancelBtn" data-dismiss="modal">Cancle</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- SignUpModal End -->
