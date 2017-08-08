
function removeActiveClass() {
    ele = document.getElementsByTagName("li");
    for (var i = 0; i < ele.length; i++)    
        ele[i].classList.remove("active");
}

function addActiveClass(ele) {
    ele.classList.add("active");
}

function loadSection(dir, ele) {
    removeActiveClass();
    $( ".menuContent" ).load( "snippets/" + dir + ".html" );
    addActiveClass(ele);
}