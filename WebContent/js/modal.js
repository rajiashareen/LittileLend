function modalclick()
{
        
        var id = $(this).attr('data-id');
        
        
        $('#userForm')
        .find('[name="id"]').val($('#catitem').val()).end()
        .find('[name="name"]').val($('#itemdescri').val()).end()
        .find('[name="email"]').val($('#itemval').val()).end()
        
        
        bootbox
        .dialog({
            title: 'Edit the user profile',
            message: $('#userForm'),
            show: false // We will show it manually later
        })
       
        .modal('show');
 }
  
        
