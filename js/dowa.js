$( document ).ready(function() {

    var pathname = window.location.pathname;
    var url      = window.location.href;
    var $mainNavigationElements = $('.nav.bs-docs-sidenav > li > a');

    $mainNavigationElements.each(
        function() {
            $(this).parent().removeClass('active');
        }
    );

    $mainNavigationElements.each(
        function() {
            var $element = $(this);
            var hrefUrl = $element.attr('href').split('#')[0];
            if (pathname.indexOf(hrefUrl) > -1) {
                $element.parent().addClass('active');
                var $links = $element.next().children('li').children('a');

                $links.click(
                    function(e) {
                        $links.each(function() {$(this).parent().removeClass('active');});
                        $(e.target).parent().addClass('active');
                        return true;
                    }
                );
            }
        }
    );
});