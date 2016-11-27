$(document).ready(function() {

	var wrote = false;
	var filter = false;

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


	$("#myCheck").click(function(){
		if(filter)
		{
			filter = false;
			$("#filter_form").css("display","none");

		}
		else {
			$("#phonesTable").find("tr:gt(0)").remove();
			filter = true;
			$("#filter_form").css("display","inline-block");

		}
	});

	var filter_string = "";
	var developer = false;
	var model = false;
	var storage = false;
	var price = false;

	$('#devCheck').change(function() {
        if($(this).is(":checked")) {
					developer = true;
					model = false;
					$('#modCheck').attr("checked", false);
					var autocomplete_param = [];
					$.get({
						url: "http://localhost:8081/rst/api/phones",
						dataType: "json",
						success: function(data){
							$.each(data, function(index){
								if(autocomplete_param.indexOf(data[index].developer) == -1)
									autocomplete_param.push(data[index].developer);
							});
							$( "#search" ).autocomplete({
								source: autocomplete_param
							});
						}
					});

				}
				else {
					developer = false;
				}
		});

	$('#modCheck').change(function() {
        if($(this).is(":checked")) {
					model = true;
					developer = false;
					$('#devCheck').attr("checked", false);
					var autocomplete_param = [];
					$.get({
						url: "http://localhost:8081/rst/api/phones",
						dataType: "json",
						success: function(data){
							$.each(data, function(index){
								if(autocomplete_param.indexOf(data[index].model) == -1)
									autocomplete_param.push(data[index].model);
							});
							$( "#search" ).autocomplete({
								source: autocomplete_param
							});
						}
					});
				}
				else {
					model = false;
				}
		});

	$("#storCheck").change(function(){
		if($(this).is(":checked")) {
			storage = true;
			$("#min_storage").css("display","inline-block");
			$("#max_storage").css("display","inline-block");
		}
		else{
			storage = false;
			$("#min_storage").css("display","none");
			$("#max_storage").css("display","none");
		}
	});

	$("#prCheck").change(function(){
		if($(this).is(":checked")) {
			price = true;
			$("#min_price").css("display","inline-block");
			$("#max_price").css("display","inline-block");
		}
		else{
			price = false;
			$("#min_price").css("display","none");
			$("#max_price").css("display","none");
		}
	});


	$("#filter_button").click(function(){
		var max_price = 0.0;
		var min_price = 0.0;
		var max_storage = 0;
		var min_storage = 0;


		filter_string = $('input[name=search]').val();


		if($('input[name=min_price]').val())
		{
			min_price = $('input[name=min_price]').val();
		}

		if($('input[name=max_price]').val())
		{
			max_price = $('input[name=max_price]').val();
		}

		if(max_price < min_price)
		{
			var helper = max_price;
			max_price = min_price;
			min_price = helper;
		}

		if($('input[name=min_storage]').val())
		{
			min_storage = $('input[name=min_storage]').val();
		}

		if($('input[name=max_storage]').val())
		{
			max_storage = $('input[name=max_storage]').val();
		}

		if(max_storage < min_storage)
		{
			var helper = max_storage;
			max_storage = min_storage;
			min_storage = helper;
		}

		var filter = JSON.stringify({
			filter: filter_string,
			developer: developer,
			model: model,
			storage: storage,
			price: price,
			lowerStorage: min_storage,
			higherStorage: max_storage,
			lowerPrice: min_price,
			higherPrice: max_price
		});

		window.alert(developer + " " + model);

		window.alert(filter);

		$.post({
			type: 'POST',
			url: 'http://localhost:8081/rst/api/filter',
			dataType: 'json',
			contentType:'application/json',
			data: filter,
			success: function(data){
				$("#phonesTable").find("tr:gt(0)").remove();
				$("table.center").css("display","inline-block");
				$.each(data, function(index){
					var tr = $('<tr>');
					tr.append("<td id=\"identification\"> " + data[index].id + "</td>");
					tr.append("<td> " + data[index].developer + "</td>");
					tr.append("<td> " + data[index].model + "</td>");
					tr.append("<td> " + data[index].storage + "GB</td>");
					tr.append("<td>$ " + data[index].price + "</td>");
					$("#phonesTable").append(tr);
				});
			},
			error: function(jqXHR, textStatus, errorThrown){
				window.alert(jqXHR.status + " " + textStatus);
			}
		});

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
			},
			error: function(jqXHR, textStatus, errorThrown){
				window.alert(jqXHR.status + " " + textStatus);
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
