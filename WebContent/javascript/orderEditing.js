$(document).ready(function(){
	
	
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("#table"+this.id+" td:last-child").html();
    // Append table with add row
    
    
    $(".tbutton").click(function(){
    	console.log("Button " + this.id + "clicked!");
        var index = $("#table"+this.id+" tbody tr:last-child").index();
        var num_box = parseInt($('#num_boxes'+this.id).val()) + 1;
        $('#num_boxes'+this.id).val(num_box);
        console.log("Added a kitchen: Current number: " + num_box);
        var row = '<tr>' +
            '<td>' +
            '<select class="form-control" id="sel_box" name="sel_box'+this.id+num_box+'" >' +
               '<option >Select...</option>' +
               '<option id="box_sh">Box with shelves</option>' +
               '<option id="box_sh3">Box 3 drawers</option>' +
               '<option id="box_sh4">Box 4 drawers</option>' +
            '</select>' +
            '</td>' +
            '<td><input class="form-control" type="text" id="height" name="box_height'+this.id+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="width" name="box_width'+this.id+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="depth" name="box_depth'+this.id+num_box+'"></td>' +
            '<td><input class="form-control" type="text" id="thik" name="box_thik'+this.id+num_box+'" value="16"></td>' +
            '<td><input type="text" class="form-control" id="melMat" name="mel'+this.id+num_box+'"></td>' +
            '<td>' +
            '<select class="form-control" id="box_colour" name="box_colour'+this.id+num_box+'" >' +
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
    	
        
        
        //var id = $(this).parents("td").attr("id");
        var id = $(this).parent("table").id;
        
        console.log("Current id: " + id);
        console.log("Current number: " + $('#num_boxes'+this.id).val());
        var num_box = parseInt($('#num_boxes'+this.id).val()) - 1;
        $('#num_boxes'+this.id).val(num_box);
        
        $(this).parents("tr").remove();
        $(".tbutton").removeAttr("disabled");
        console.log("Deleted a kitchen: Current number: " + num_box);
        
        //get all the rows of the table
        var rows = $('#table'+this.id+' > tbody > tr');
        
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
        //console.log(rows);
    });

});