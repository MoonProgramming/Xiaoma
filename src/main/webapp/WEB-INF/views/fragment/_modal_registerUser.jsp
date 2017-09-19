<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
	aria-labelledby="Register" aria-hidden="true">
	<div class="modal-dialog">
		<form class="modal-content" action="userRegister" method="post">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="registerModalLabel">免費註冊</h4>
				<small>有<span class="glyphicon glyphicon-asterisk"
					aria-hidden="true"></span> 標誌的必須填寫
				</small>
			</div>
			<div class="modal-body">

				<div class="form-group">
					<label for="recipient-name" class="control-label">姓名：</label> 
					<input type="text" class="form-control" maxlength="50" name="userName"
						id="user-input-displayName">

				</div>

				<div class="form-group">
					<label for="example-tel-input" class="control-label"
						data-toggle="tooltip" data-placement="top"
						title="已預約的陪月嫂將以此電話號碼聯絡你">電話：(Whatsapp) <span
						class="glyphicon glyphicon-question-sign" aria-hidden="true"></span></label>

					<input class="form-control" type="tel" maxlength="20"
						name="phone" placeholder="例: 60123456789"
						id="user-input-Tel">

				</div>

				<div class="form-group">
					<label for="recipient-email" class="control-label"><span
						class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>
						電郵：</label> <input type="email" class="form-control" maxlength="50" name="email"
						id="user-input-email" aria-describedby="emailHelp"> <small
						id="emailHelp" class="form-text text-muted">本網站須要憑電郵作為確認您的戶口</small>
				</div>

				<div class="form-group">
					<label for="example-date-input" class="control-label"
						data-toggle="tooltip" data-placement="top"
						title="先輸入大概日期，之後仍可以在個人賬戶內修改">寶寶預產期： <span
						class="glyphicon glyphicon-question-sign" aria-hidden="true"></span></label>

					<input class="form-control" type="date" placeholder="1950-08-19" name="childBirthdate"
						id="user-date-childBirthdate">

				</div>

				<div class="form-group">
					<label class="control-label" for="home_address"> <span
						class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>居住地址：
					</label>

					<textarea class="form-control" maxlength="300"
						id="user-textarea-homeaddress" name="address"
						placeholder="完整地址" aria-describedby="addressHelp"></textarea>
					<small id="addressHelp" class="form-text text-muted">已預約的陪月嫂將以此地址服務你，註冊後不能刪改</small>

				</div>

				<div class="form-group">
					<label for="message-text" class="control-label"><span
						class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>
						設定密碼：</label> <input type="password" class="form-control" maxlength="20" name="password"
						id="user-text-password" placeholder="最少六個英文字母或數字">

				</div>

				<div class="form-group">
					<label for="message-text" class="control-label"><span
						class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>
						再填密碼：</label> <input type="password" class="form-control" maxlength="20" name="retype-password"
						id="user-text-confirmPassword" placeholder="再填一次密碼">
				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
				<button type="submit" class="btn btn-primary" id="doRegister">註冊</button>
			</div>
		</form>
	</div>
</div>