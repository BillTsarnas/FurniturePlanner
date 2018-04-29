$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("#table1 td:last-child").html();
    // Append table with add row
    $(".add-new").click(function(){      
        var index = $("#table1 tbody tr:last-child").index();
        
        var num_fur = parseInt($('#num_furniture').val()) + 1;
        $('#num_furniture').val(num_fur);
        console.log("Added a furniture: Current number: " + num_fur);
        
        var row = '<tr>' +
            '<td><select class="form-control" id="selector" name="fur_kind'+num_fur+'"><option selected id="kitchen">Kitchen</option> <option id="wardrobe">Wardrobe</option> </select></td>' +
            '<td><input required type="text" id="status" class="form-control" name="fur_name'+num_fur+'"></td>' +
            '<td width="10%">' +
	           '<a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>' +
	           '</td>' +
            '</tr>';
           
        $("#table1").append(row);     
        $("#table1 tbody tr").eq(index + 1).find(" .add").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
	
    //Delete row
    $(document).on("click", ".delete", function(){
        $(this).parents("tr").remove();
        $(".add-new").removeAttr("disabled");
        
        var num_fur = $('#num_furniture').val() - 1;
        $('#num_furniture').val(num_fur);
        console.log("Deleted a kitchen: Current number: " + num_fur);
        
        //get all the rows of the table
        var rows = $('#table1 > tbody > tr');
        
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
        
        
    });

});