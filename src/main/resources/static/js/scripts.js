/* Save (delete) collapsable items from local storage */
$('.filter-collapse').on({
    'shown.bs.collapse': function () {
        let active = $(this).attr('id');
        let collapseItems = localStorage.collapseItems === undefined ? [] : JSON.parse(localStorage.collapseItems);
        if ($.inArray(active, collapseItems) === -1) {
            collapseItems.push(active);
        }
        localStorage.collapseItems = JSON.stringify(collapseItems);
    },
    'hidden.bs.collapse': function() {
        let active = $(this).attr('id');
        let collapseItems = localStorage.collapseItems === undefined ? [] : JSON.parse(localStorage.collapseItems);
        let elementIndex = $.inArray(active, collapseItems);

        if (elementIndex !== -1) {
            collapseItems.splice(elementIndex, 1);
        }

        localStorage.collapseItems = JSON.stringify(collapseItems);
    }
});

/* Show collapsable items */
$(document).ready(function () {
    let collapseItems = localStorage.collapseItems === undefined ? [] : JSON.parse(localStorage.collapseItems);

    for (let i in collapseItems) {
        let item = $('#' + collapseItems[i]);

        if (item.hasClass('collapse')) {
            item.collapse('show');
        }
    }
});

/* Submit form on changes */
$(document).ready(function () {
   $('form').on('change', function () {
       document.forms['filter'].submit();
   });
});