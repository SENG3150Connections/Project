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

// Place any jQuery/helper plugins in here.
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
        onSelect: function() {
            startDate = this.getDate();
            updateStartDate();
        }
    }),
    endPicker = new Pikaday({
        field: document.getElementById('end'),
        minDate: new Date(),
        maxDate: new Date(2020, 12, 31),
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