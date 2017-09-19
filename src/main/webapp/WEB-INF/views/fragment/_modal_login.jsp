<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
	aria-labelledby="Login" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="loginModalLabel">Login</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="recipient-name" class="control-label">Email:</label> <input
						type="text" class="form-control" maxlength="50" id="loginEmail">
				</div>
				<div class="form-group">
					<label for="message-text" class="control-label">Password:</label> <input
						type="password" class="form-control" maxlength="20"
						id="loginPassword">
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="doLogin">Login</button>
			</div>
		</div>
	</div>
</div>