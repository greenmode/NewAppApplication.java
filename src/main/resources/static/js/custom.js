$('table td').each(function(){
    switch ($(this).text()) {
        case 'Черновик':
            $(this).parent('tr').addClass('table-secondary');
            break;
        case 'На рассмотрении у владельца сервиса':
            $(this).parent('tr').addClass('table-warning');
            break;
        case 'Отклонена владельцем сервиса':
            $(this).parent('tr').addClass('table-danger');
            break;
        case 'Согласована владельцем сервиса':
            $(this).parent('tr').addClass('table-warning');
            break;
        case 'На рассмотрении админа':
            $(this).parent('tr').addClass('table-warning');
            break;
        case 'Отклонена админом':
            $(this).parent('tr').addClass('table-danger');
            break;
        case 'Выполнена':
            $(this).parent('tr').addClass('table-success');
            break;
    }
});

var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl);
});