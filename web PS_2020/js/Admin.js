
$(document).ready(function()    {
    $("#request_patients").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/patient-management/all-patients',
			dataType: 'json',
            success: function(data){

                var str="";
                $.each(data, function (i, patient) {
                    str = str + patient.firstName + ", ";
                })
                $("#patients").attr("placeholder", str); 
			},
            error: function(){
                $("#patients").html("error")
            }
        });
    });
});

$(document).ready(function()    {
    $("#request_echip").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/patient-management/all-examinations',
			dataType: 'json',
            success: function(data){
				
                var str="";
                $.each(data, function (i, examination) {
                    str = str + examination.id + ", ";
                })
                $("#examinations").attr("placeholder", str); 
			},
            error: function(){
                $("#examinations").html("error")
            }
        });
    });
});

$(document).ready(function()    {
    $("#request_doctors").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/patient-management/all-doctors',
			dataType: 'json',
            success: function(data){

                var str="";
                $.each(data, function (i, doctor) {
                    str = str + doctor.username + ", ";
                })
                $("#doctors").attr("placeholder", str); 
			},
            error: function(){
                $("#doctors").html("error")
            }
        });
    });
});


$(document).ready(function()    {

    
    var $ssn = $('#ssn');
    var $firstName = $('#firstName');
    var $lastName = $('#lastName');
    var $tip = $('#tip');
    
    $("#request_insert_patient").click(function(e)    {

        var PatientObject = {
            ssn: $ssn.val(),
            firstName: $firstName.val(),
			lastName: $lastName.val(),
        };

        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/patient-management/add-patient',
            data: JSON.stringify(ClientObject),
            contentType: 'application/json',
            success: function(data){
                console.log(data);
  
            },
            error: function(){
                $("#patients").html("error")
            }
        });
    });
});