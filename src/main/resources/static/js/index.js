layui.use(['form', 'layer', 'jquery', 'table'], function () {
    var form = layui.form;
    var $ = layui.jquery;
    var table = layui.table;
    var p = 1;

    form.verify({
        ticket: function (value) {
            if (value.length == 0) return '请输入票号!';
            if (value.length != 19) return '票号格式不正确!'
        }
    })

    form.on('submit(select)', function (data) {
        loadTable(data.field)
        return false;
    })

    function loadTable(data) {
        table.render({
            elem: '#list',
            url: '/goods/loadTable',
            title: '药品信息',
            page: {
                layout: ['prev', 'page', 'next', 'count', 'skip']
            },
            toolbar: '#headTool',
            defaultToolbar: ['filter', 'exports'],
            where: {
                ticket: data.ticket
            },
            limit: 11,
            cols: [
                [
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'gName', title: '药品名称'},
                    {field: 'cd', title: '产地'},
                    {field: 'gg', title: '规格'},
                    {field: 'ph', title: '批号'},
                    {
                        field: 'scrq', title: '生产日期', templet: function (d) {
                            var scrq = d.scrq.toString();
                            var year = scrq.substring(0, 4);
                            var monty = scrq.substring(4, 6);
                            var day = scrq.substring(6, 8);
                            return year + '年' + monty + '月' + day + '日';
                        }
                    },
                    {
                        field: 'yxq', title: '有效期至', templet: function (d) {
                            var yxq = d.yxq.toString();
                            var year, monty, day;
                            year = yxq.substring(0, 4);
                            monty = yxq.substring(4, 6);
                            if (yxq.length == 8) {
                                day = yxq.substring(6, 8);
                                return year + '年' + monty + '月' + day + '日';
                            } else {
                                return year + '年' + monty + '月';
                            }
                        }
                    },
                    {
                        field: 'zjdPathList', title: '质检单', width: 120, align: 'center', templet: function (d) {
                            var zjd = d.zjdPathList;
                            if (zjd.length == 0) {
                                return '暂无';
                            } else {
                                return '<button class="layui-btn layui-btn-xs layui-btn-normal" lay-event="zjdView">预览</button><button class="layui-btn layui-btn-xs" lay-event="zjdDown">下载</button>';
                            }
                        }
                    },
                    {
                        field: 'pjPathList', title: '批件', width: 120, align: 'center', templet: function (d) {
                            var pj = d.pjPathList;
                            if (pj.length == 0) {
                                return '暂无';
                            } else {
                                return '<button class="layui-btn layui-btn-xs layui-btn-normal" lay-event="pjView">预览</button><button class="layui-btn layui-btn-xs" lay-event="pjDown">下载</button>';
                            }
                        }
                    },
                    {title: '操作', width: 100, align: 'center', toolbar: '#operation'}
                ]
            ],
            done: function (res, curr, count) {
                p = curr
            }
        })
    }

    function openPhotos(data, type) {
        var imgs = [];
        if ('zjd' === type) {
            $.each(data.zjdPathList, function (d, i) {
                var src = '/image/previewImage/' + i;
                var alt = i;
                imgs.push({alt: alt, pid: 1, src: src, thumb: ''})
            });
        } else {
            $.each(data.pjPathList, function (d, i) {
                var src = '/image/previewImage/' + i;
                var alt = i;
                imgs.push({alt: alt, pid: 1, src: src, thumb: ''})
            });
        }
        var photos = {data: imgs, id: 0, start: 0, title: ''};
        layer.photos({
            photos: photos
            , anim: 5
        });
    }

    function postDownLoadFile(options) {
        var config = $.extend(true, {method: 'post'}, options);
        var $iframe = $('<iframe id="down-file-iframe" />');
        var $form = $('<form target="down-file-iframe" method="' + config.method + '" />');
        $form.attr('action', config.url);
        for (var key in config.data) {
            $form.append('<input type="hidden" name="' + key + '" value="' + config.data[key] + '" />');
        }
        $iframe.append($form);
        $(document.body).append($iframe);
        $form[0].submit();
        $iframe.remove();
    }

    table.on('toolbar(list)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'batchDown': {
                var data = checkStatus.data;
                if (data.length < 2) {
                    layer.msg("请至少选择两条记录!");
                } else {
                    // 批量下载
                    var goodss = [];
                    $.each(data, function (d, i) {
                        goodss.push({
                            gName: i.gName,
                            ticket: i.ticket,
                            zjdPathList: i.zjdPathList,
                            pjPathList: i.pjPathList
                        })
                    })
                    var str = JSON.stringify(goodss).replace(/\"/g, "'");
                    postDownLoadFile({
                        url: '/image/batchDown',
                        data: {goodss: str},
                        method: 'post'
                    })
                }
                break;
            }
        }
    })

    table.on('tool(list)', function (obj) {
        var data = obj.data;
        switch (obj.event) {
            case 'zjdView': {
                openPhotos(data, 'zjd');
                break;
            }
            case 'pjView': {
                openPhotos(data, 'pj');
                break;
            }
            case 'zjdDown': {
                var imgs = [];
                $.each(data.zjdPathList, function (d, i) {
                    imgs.push('zjd--' + i)
                })
                postDownLoadFile({
                    url: '/image/down',
                    data: {gName: data.gName, imgs: imgs},
                    method: 'post'
                })
                break;
            }
            case 'pjDown': {
                var imgs = [];
                $.each(data.pjPathList, function (d, i) {
                    imgs.push('pj--' + i)
                })
                postDownLoadFile({
                    url: '/image/down',
                    data: {gName: data.gName, imgs: imgs},
                    method: 'post'
                })
                break;
            }
            case 'downAll': {
                var imgs = [];
                $.each(data.zjdPathList, function (d, i) {
                    imgs.push('zjd--' + i)
                })
                $.each(data.pjPathList, function (d, i) {
                    imgs.push('pj--' + i)
                })
                postDownLoadFile({
                    url: '/image/down',
                    data: {gName: data.gName, imgs: imgs},
                    method: 'post'
                })
                break;
            }
        }
    })
});