$(document).ready(function() {

	var wrote = false;
	$("#button").click(function (){

		if(!wrote)
		{
			$("table.center").css("display","inline-block");
			$("#tablePos").css("margin","0 auto");
			$("table.center").css("max-height","200px");
			$("table.center").css("overflow-y","scroll");
			wrote = true;
		}

		$.get({
			url: "http://localhost:8081/rst/api/phones",
			dataType: "json",
			success: function(data){
				console.log(data);
				$.each(data, function(index){
					var tr = $('<tr>');
					tr.append("<td id=\"identification\"> " + data[index].id + "</td>");
					tr.append("<td> " + data[index].developer + "</td>");
					tr.append("<td> " + data[index].model + "</td>");
					tr.append("<td> " + data[index].storage + "GB</td>");
					tr.append("<td>$ " + data[index].price + "</td>");
					$("#phonesTable").append(tr);
				});
			}

		});
	});

		$("table.center").scroll(function() {
			if ($(this).height() + $(this).scrollTop() == $(this)[0].scrollHeight) {

				$.get({
					url: "http://localhost:8081/rst/api/phones",
					dataType: "json",
					success: function(data){
						console.log(data);
						$.each(data, function(index){
							var tr = $('<tr>');
							tr.append("<td id=\"identification\"> " + data[index].id + "</td>");
							tr.append("<td> " + data[index].developer + "</td>");
							tr.append("<td> " + data[index].model + "</td>");
							tr.append("<td> " + data[index].storage + "GB</td>");
							tr.append("<td>$ " + data[index].price + "</td>");
							$("#phonesTable").append(tr);
						});
					}
				});
			}
		});


	$("#Submit").click(function(){

		var phone = JSON.stringify({
			id: parseInt($('input[name=id]').val()),
			developer: $('input[name=developer]').val(),
			model: $('input[name=model]').val(),
			storage: $('input[name=storage]').val(),
			price: $('input[name=price]').val()
		});

		$.post({
			type: 'POST',
			url: 'http://localhost:8081/rst/api/phones',
			dataType: 'json',
			contentType:'application/json',
			data: phone,
			success: function(data){
				console.log(data);
			}
		});


	});

	$("#new").click(function(){
		if($("#newForm").css("display") != "none")
		{
			$("#newForm").css("display","none");
		}
		else
		{
			$("#newForm").css("display","block");
		}


	});

	$("#clear").click(function(){
		 $("table.center").css("display","none");
		 wrote = false;
	   $("#phonesTable").find("tr:gt(0)").remove();
	});
});
