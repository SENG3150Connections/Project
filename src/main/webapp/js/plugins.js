// Avoid `console` errors in browsers that lack a console.
(function() {
    var method;
    var noop = function () {};
    var methods = [
        'assert', 'clear', 'count', 'debug', 'dir', 'dirxml', 'error',
        'exception', 'group', 'groupCollapsed', 'groupEnd', 'info', 'log',
        'markTimeline', 'profile', 'profileEnd', 'table', 'time', 'timeEnd',
        'timeline', 'timelineEnd', 'timeStamp', 'trace', 'warn'
    ];
    var length = methods.length;
    var console = (window.console = window.console || {});

    while (length--) {
        method = methods[length];

        // Only stub undefined methods.
        if (!console[method]) {
            console[method] = noop;
        }
    }
}());

// Pikaday Calendar properties
(function() {
var startDate,
    endDate,
    updateStartDate = function() {
        startPicker.setStartRange(startDate);
        endPicker.setStartRange(startDate);
        endPicker.setMinDate(startDate);
    },
    updateEndDate = function() {
        startPicker.setEndRange(endDate);
        startPicker.setMaxDate(endDate);
        endPicker.setEndRange(endDate);
    },
    startPicker = new Pikaday({
        field: document.getElementById('start'),
        minDate: new Date(),
        maxDate: new Date(2020, 12, 31),
        format: 'YYYY-MM-D h:mm:ss',
        onSelect: function() {
            startDate = this.getDate();
            updateStartDate();
        }
    }),
    endPicker = new Pikaday({
        field: document.getElementById('end'),
        minDate: new Date(),
        maxDate: new Date(2020, 12, 31),
        format: 'YYYY-MM-D h:mm:ss',
        onSelect: function() {
            endDate = this.getDate();
            updateEndDate();
        }
    }),
    _startDate = startPicker.getDate(),
    _endDate = endPicker.getDate();

if (_startDate) {
    startDate = _startDate;
    updateStartDate();
}

if (_endDate) {
    endDate = _endDate;
    updateEndDate();
}
}());

// Results Page manipulation
var str;
$("a.content-toggle").click(function() {
    $('#filters').animate({height: ($('#filters').height() == 0) ? $(window).height()-250 : 0}, 200);
    $('#filters>div').toggleClass('invisible');
    $( this ).toggleClass( "fa-chevron-right-after" );
    $( this ).toggleClass( "fa-chevron-down-after" );
});
$( ".offer-heart" ).click(function() {
    $( this ).toggleClass( "fa-heart" );
    $( this ).toggleClass( "fa-heart-o" );
    $( this ).toggleClass( "red" );
});
$("#display-list").click(function() {
    $('#results').addClass('flex-col').removeClass('flex-row');
    $('.offer-tile').toggleClass('offer-list').toggleClass('offer-tile');
});
$("#display-tile").click(function() {
    $('#results').addClass('flex-row').removeClass('flex-col');
    $('.offer-list').toggleClass('offer-tile').toggleClass('offer-list');
});
$(".offer-list > .offer-images").on('click', function() {
    $('#results').addClass('hidden');
    $('#display-type').addClass('hidden');
    $('.offer-list').addClass('hidden');
    $('#offer-info-large').removeClass('hidden');
    str = $(this).parent().find(".name").text();
    $('#offer-name').html(str);
    str = $(this).parent().find(".blurb").text();
    $('#offer-desc').html(str);
    str = $(this).parent().find(".addr").text();
    $('#offer-addr').html(str);
    str = $(this).parent().find(".contact").text();
    $('#offer-contact').html(str);
    str = $(this).parent().find(".email").text();
    $('#offer-email').html(str);
    str = $(this).parent().find(".website").text();
    $('#offer-website').html(str);
    str = $(this).parent().find(".offer-img-initial").clone();
    $('#offer-image img').replaceWith(str);
});
$(".offer-list > .offer-info").on('click', function() {
    $('#results').addClass('hidden');
    $('#display-type').addClass('hidden');
    $('.offer-list').addClass('hidden');
    $('#offer-info-large').removeClass('hidden');
    str = $(this).parent().find(".name").text();
    $('#offer-name').html(str);
    str = $(this).parent().find(".blurb").text();
    $('#offer-desc').html(str);
    str = $(this).parent().find(".addr").text();
    $('#offer-addr').html(str);
    str = $(this).parent().find(".contact").text();
    $('#offer-contact').html(str);
    str = $(this).parent().find(".email").text();
    $('#offer-email').html(str);
    str = $(this).parent().find(".website").text();
    $('#offer-website').html(str);
    str = $(this).parent().find(".offer-img-initial").clone();
    $('#offer-image img').replaceWith(str);
});
$("#show-results").on('click', function() {
    $('#offer-info-large').addClass('hidden');
    $('#results').removeClass('hidden');
    $('#display-type').removeClass('hidden');
    $('.offer-list').removeClass('hidden');
});