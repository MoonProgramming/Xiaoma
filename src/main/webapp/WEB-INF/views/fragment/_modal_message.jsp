<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Check if updateMessage is not null or not empty -->
<c:if test="${not empty updateMessage}">

	<script>
		window.onload = function() {
			$('#messageModalLabel').html(
					'<span class="text-info">${updateMessage}</span>');
			$('#messageModal').modal('show');
		};
	</script>
	
	<c:remove scope="request" var="updateMessage" />
	
</c:if>

<div class="modal fade" id="messageModal" tabindex="-1" role="dialog"
	aria-labelledby="Message" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="messageModalLabel">Message</h4>
			</div>
			<div class="modal-footer">
				<div class="pre-auth">
					<button type="button" class="btn btn-default pull-right"
						data-dismiss="modal">關閉</button>
				</div>
				<div class="post-auth"></div>
			</div>
		</div>
	</div>
</div>