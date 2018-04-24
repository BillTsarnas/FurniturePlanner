$(document).ready(function(){
	
	
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("#table"+this.id+" td:last-child").html();
    // Append table with add row
    
    
    $(".tbutton").click(function(){      
        var index = $("#table"+this.id+" tbody tr:last-child").index();
        var num_box = parseInt($('#num_boxes').val()) + 1;
        $('#num_boxes').val(num_box);
        console.log("Added a kitchen: Current number: " + num_box);
        var row = '<tr>' +
            '<td>' +
            '<select class="form-control" id="sel_box" name="sel_box" >' +
               '<option >Select...</option>' +
               '<option id="box_sh">Box with shelves</option>' +
               '<option id="box_sh3">Box 3 drawers</option>' +
               '<option id="box_sh4">Box 4 drawers</option>' +
            '</select>' +
            '</td>' +
            '<td><input class="form-control" type="text" id="height" name="box_height'+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="width" name="box_width'+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="depth" name="box_depth'+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="thik" name="thik'+num_box+'" value="16"></td>' +
            '<td><input type="text" class="form-control" id="melMat" name="box_colour"></td>' +
            '<td>' +
            '<select class="form-control" id="sel_dcol1" name="sel_dcol" >' +
                '<option >Select...</option>' +
                '<option id="wood">Wood</option>' +
                '<option id="brown">Brown</option>' +
                '<option id="red">Red</option>' +
                '<option id="white">White</option>' +
            '</select>' +
            '</td>' +
            '<td>' +
            '<a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>';
           
        $("#table"+this.id).append(row);     
        $("#table"+this.id+" tbody tr").eq(index + 1).find(" .add").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    //Delete row
    $(document).on("click", ".delete", function(){
    	
        $(this).parents("tr").remove();
        $(".tbutton").removeAttr("disabled");
        
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