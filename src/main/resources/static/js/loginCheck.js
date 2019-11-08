layui.use(['form', 'layer', 'jquery'], function () {
    // 操作对象
    var form = layui.form;
    var $ = layui.jquery;
    var res = number();

    //生成随机数字 并计算结果
    function number() {
        var m = '+';
        var a = Math.floor(Math.random() * 50);
        var b = Math.floor(Math.random() * 50);
        if (Math.random() > 0.5) m = '-';
        if (b > a) {
            var c = a;
            a = b;
            b = c;
        }
        $('#display').html('请计算: ' + a + ' ' + m + ' ' + b + ' = ?')
        var res = 0;
        if (m == '+') res = a + b;
        else res = a - b;
        return res;
    }

    //绑定算式按钮
    $('#display').click(function () {
        res = number();
    })

    //验证
    form.verify({
        code: function (value) {
            if (value.length == 0) return "请输入验证码";
            if (parseInt(value) != res) return "验证码错误";
        }
    });

    form.on('submit(login)', function (data) {
        $.ajax({
            url: '/customer/login',
            data: data.field,
            type: 'post',
            success: function (d) {
                if (d) {
                    location.href = "/index.html";
                } else {
                    layer.msg('编号或密码错误!');
                }
            }
        })
        return false;
    })
});

