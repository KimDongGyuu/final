<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/style.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#left {
	width: 200px;
	height: 600px;
	float: left;
	border-right: 2px solid darkblue;
	margin-left: 50px;
}

#right {
	width: 900px;
	height: 600px;
	margin-left: 260px;
}

#bt {
	width: 180px;
	height: 40px;
}
</style>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script>
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var roadAddr = data.roadAddress; 
                var extraRoadAddr = ''; 

                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }

                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                document.getElementById("sample4_roadAddress").value = roadAddr;
                
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<script>
function sbm(event) {
	var addr2 = document.getElementById('sample4_roadAddress').value;
	var addr4 = document.getElementById('sample4_detailAddress').value;
	var addr5 = document.getElementById('sample4_extraAddress').value;
	
	var fullAddr = addr2 + '/' + addr4 + '/' + addr5;
	document.getElementById('event_addr').value = fullAddr;
	document.getElementById('event_addr').submit();
}

window.onload = function() {
    var DBaddress = "${eventDto.event_addr}";
    var addressParts = DBaddress.split('/');

    document.getElementById("sample4_roadAddress").value = addressParts[0].trim();
    document.getElementById("sample4_detailAddress").value = addressParts[1].trim();
    document.getElementById("sample4_extraAddress").value = addressParts[2].trim();
};
</script>
</head>
<body>
	<div>
		<div id="left">
			<button id="bt" type="button" class="btn btn-outline-primary"
				onclick="location.href='company_event_List.do?com_idx=${dto.getCom_idx()}';">목록</button>
			
			
			<div class="mt-3"><a href="company_news_List.do?com_idx=${dto.getCom_idx()}">회사소식</a> <br> <a href="company_event_List.do?com_idx=${dto.getCom_idx()}">경조사</a></div>
			
		</div>
		
		<form name="company_eventUpdate" action="company_eventUpdate.do" method="post" onsubmit="sbm()">
		
		<input type="hidden" name="event_idx" value="${eventDto.event_idx}">
		<input type="hidden" id="event_addr" name="event_addr">
		
		<div id="right"> 
		<div class="container">
		
		<div class="mt-5 mb-2"><span class="h4">경조사 &gt;&gt; ${eventDto.event_idx}번 게시글 수정</span></div>
		
		<div class="mb-2 d-flex gap-2">
		<input type="text" name="event_title" class="form-control" value="${eventDto.event_title}" autocomplete="off" id="event_title">
		<input type="text" name="event_writer" class="form-control" id="event_writer" value="${eventDto.event_writer}">
		</div>
		

		<div class="mb-2 d-flex gap-2">
		<input type="button" class="btn btn-outline-primary" onclick="sample4_execDaumPostcode()" value="주소검색">
		<input type="text" class="form-control" id="sample4_roadAddress" name="addr2">

		<span id="guide" style="color:#999;display:none"></span>
		</div>
		<div class="mb-2 d-flex gap-2">
		<input type="text" class="form-control" id="sample4_detailAddress" name="add4">
		<input type="text" class="form-control" id="sample4_extraAddress" name="addr5">
		</div>

		 <div>
		 	<textarea id="summernote" name="event_content">${eventDto.event_content}</textarea>
		 </div>	
		 
		 <div class="mt-2 d-flex gap-2 justify-content-center">
		<button class="btn btn-primary" id="submit">저장</button>
		</div>
		
		</div>
  <script>
      $('#summernote').summernote({
        placeholder: '내용을 입력해 주세요.',
        tabsize: 2,
        height: 300,
        width :875,
        
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],      
          ['view', ['codeview', 'help']]
        ]
      });
      
      $('textarea[name="news_content"]').html($('.summernote').code());
    </script> 
		</div>
</form>
		
	</div>
</body>
</html>