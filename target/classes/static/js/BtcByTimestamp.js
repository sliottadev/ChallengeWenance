$(document).ready(function() {
});

function modalSelectTimestamp(idDate, idTime, idAux){
	console.log("modalSelectTimestamp");
	$.ajax({
  		url: "/api/getTimeStamps",
	})
	.done((response)=>{
		showModalSelectTimestamp(response, idDate, idTime, idAux);
	})
	.fail(()=>{
		console.log("ERROR");
	})
}

function getTimestamp(){
	time = $("#timestampSelected").val();
	if (time=="-1"){
		msgError();
		return;	
	} 
	$.ajax({
  		url: "/api/getStateByTimestamp?time="+time,
  		method:"GET"
	})
	.done((response)=>{
		addToTable(response);
	})
	.fail(()=>{
		console.log("ERROR");
	})
}

function addToTable(data){
	console.log(data);
	var table = document.getElementById("tableResult");
  	var row = table.insertRow(1);
  	var cell1 = row.insertCell(0);
  	var cell2 = row.insertCell(1);
  	cell1.innerHTML = data.timestamp;
  	cell2.innerHTML = "U$S "+data.lprice.toFixed(3);
}

function showModalSelectTimestamp(response, idDate, idTime, idAux){
	Swal.fire({
  		title: '<h5>Select Timestamp</h5>',
		html: getHtmlToSelectTimestamp(response, idDate, idTime, idAux),
		showCancelButton: false,
		showConfirmButton: false
	})
}


function getHtmlToSelectTimestamp(response, idDate, idTime, idAux){
	result = ""+
		"<div class='selectTimestamp_table'>"+
		"<table class='table table-hover'> "+
		"	<thead> "+
		"		<tr> "+
		"			<th scope='col'>Timestamp</th> "+
		"		</tr> "+
		"	</thead> "+
		"	<tbody> ";
		for (var i=0; i<response.length; i++){
			result = result +
			"		<tr> "+
			"			<th scope='row' onclick='setTimeStampOnInput(\""+response[i]+"\",\""+response[i]+"\", "+idDate+", "+idTime+", "+idAux+")'> "+convertFormat(response[i])+"</th> "+
			"		</tr> ";
		}
		result = result +
		"	</tbody> "+
		"</table>"+
		"</div>";
	return result;
}

function setTimeStampOnInput(timestamp, time, idDate, idTime, idAux){
	console.log(timestamp);
	year  = timestamp.substring(0,4);
	month = timestamp.substring(5,7);
	day   = timestamp.substring(8,10);
	hour  = timestamp.substring(11,13);
	min   = timestamp.substring(14,16);
	sec   = timestamp.substring(17,19);
	$(idDate).val(year+"-"+month+"-"+day);
	$(idTime).val(hour+":"+min+":"+sec);
	$(idAux).val(time);
	swal.close();
}

function convertFormat(date){
	//2022-03-21T01:27:47.003+00:00
	year  = date.substring(0,4);
	month = date.substring(5,7);
	day   = date.substring(8,10);
	hour  = date.substring(11,13);
	min   = date.substring(14,16);
	sec   = date.substring(17,19);
	return (day+"/"+month+"/"+year+" "+hour+":"+min+":"+sec);
}

function getTimestampComparation(){
	time1=$("#timestampSelected_1").val()
	time2=$("#timestampSelected_2").val()
	if (time1=="-1" || time2=="-1") {
		msgError();
		return;	
	} 
	$.ajax({
  		url: "/api/getSummaryByTimestamp?time1="+time1+"&time2="+time2,
  		method:"GET"
	})
	.done((response)=>{
		addToTableResult(response);
	})
	.fail(()=>{
		console.log("ERROR");
	})	
}

function addToTableResult(data){
	console.log(data);
	var table = document.getElementById("tableResult");
  	var row = table.insertRow(1);
  	var cell1 = row.insertCell(0);
  	var cell2 = row.insertCell(1);
  	var cell3 = row.insertCell(2);
  	var cell4 = row.insertCell(3);
  	var cell5 = row.insertCell(4);
  	var cell6 = row.insertCell(5);
  	var cell7 = row.insertCell(6);
  	cell1.innerHTML = data.date1;
  	cell2.innerHTML = "U$S "+data.price1.toFixed(3);
  	cell3.innerHTML = data.date2;
  	cell4.innerHTML = "U$S "+data.price2.toFixed(3);
  	cell5.innerHTML = "U$S "+data.averange.toFixed(3);
  	cell6.innerHTML = "U$S "+data.maxPrice.toFixed(3);
  	cell7.innerHTML = getPercentString(data.averange, data.maxPrice, data.percentWithMax);
}

function getPercentString(av, max, perc){
 let symbol = (av > 0) ? "" : "-"
 let value = perc;
 return symbol + value.toFixed(6) + "%"
}

function msgError(){
	Swal.fire({
  		icon: 'error',
  		title: 'Oops...',
  		text: 'You forgot to select a date!',
  		width: 300,
	})
}
