layui.use('element', function () {
    var element = layui.element;
    var $ = layui.$;
    var key = $('title').text();
    $('.layui-nav-tree li a:contains(' + key + ')').parent().addClass('layui-nav-itemed');
});