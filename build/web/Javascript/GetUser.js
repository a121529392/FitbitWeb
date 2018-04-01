/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function GetALLUser() {


    var table = "Summary";
    var data1 = {
        table: table
    };
    console.log(data1);


    $.ajax({
        type: "Get",
        url: "SelectDetailData.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            console.log(data.size);
            Alldata = jQuery.trim(data).split("?");
            timedata = jQuery.trim(Alldata[0]).split("\n");
            valuedata = jQuery.trim(Alldata[1]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                }
                drawheart();
                
            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });

}


