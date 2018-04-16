$(document).ready(function(){
	
	
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("#table1 td:last-child").html();
    // Append table with add row
    
    
    $(".add-new").click(function(){      
        var index = $("#table1 tbody tr:last-child").index();
        var num_box = parseInt($('#num_boxes').val()) + 1;
        $('#num_boxes').val(num_box);
        console.log("Added a kitchen: Current number: " + num_box);
        var row = '<tr>' +
            '<td><input type="text" class="form-control" id="box" name="box_name'+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="height" name="box_height'+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="width" name="box_width'+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="depth" name="box_depth'+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="depth" name="box_num_shelves'+num_box+'" value="0"></td>' +
            '<td><input type="text" class="form-control" id="melMat" name="box_colour'+num_box+'"></td>' +
            '<td><input type="text" class="form-control" id="doorColour" name="door_colour'+num_box+'"></td>' +
            '<td>' + actions + '</td>' +
            '</tr>';
           
        $("#table1").append(row);     
        $("#table1 tbody tr").eq(index + 1).find(" .add").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    //Delete row
    $(document).on("click", ".delete", function(){
    	
        $(this).parents("tr").remove();
        $(".add-new").removeAttr("disabled");
        
        var num_box = $('#num_boxes').val() - 1;
        $('#num_boxes').val(num_box);
        console.log("Deleted a kitchen: Current number: " + num_box);
        
        //get all the rows of the table
        var rows = $('tbody > tr');
        
        //for every column (td), change the value of attribute "name" of its child input element
        //so that the names of the fields have the number of the row attached in the end (e.g box_name1)
        for(i=0; i<rows.length; i++){
        	cols = rows[i].getElementsByTagName('td');
        	for(j=0; j<cols.length - 1; j++){
        		cur_name = cols[j].childNodes[0].getAttribute("name");
        		cur_name = cur_name.substr(0,cur_name.length - 1 ) + (i+1);
        		cols[j].childNodes[0].setAttribute("name",cur_name);
        	}
        }
        console.log(rows);
    });

});