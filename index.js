const express = require('express');
const bodyParser = require('body-parser');
const { conn, sql } = require('./connect');

const app = express();
app.use(bodyParser.json());

app.get('/noidia', async (req, res) => {
    try {
        const pool = await conn; // Kết nối tới cơ sở dữ liệu
        
        const sqlString = "SELECT noidi,noiden, thoigianbay, giave, hinhanh FROM vemaybay where baynoidia=1";

        // Thực hiện truy vấn
        const result = await pool.request().query(sqlString);

        // Kiểm tra kết quả và trả về phản hồi
        res.json({
            status: 200,
            message: "Find All",
            data: result.recordset // Lấy dữ liệu từ recordset
        });
    } catch (error) {
        console.error(error); // Log lỗi
        res.status(500).json({
            status: 400,
            message: "Lỗi truy xuất",
            data: []
        });
    }
});
app.get('/quocte', async (req, res) => {
    try {
        const pool = await conn; // Kết nối tới cơ sở dữ liệu
        
        const sqlString = "SELECT noidi,noiden, thoigianbay, giave, hinhanh FROM vemaybay where baynoidia=0";

        // Thực hiện truy vấn
        const result = await pool.request().query(sqlString);

        // Kiểm tra kết quả và trả về phản hồi
        res.json({
            status: 200,
            message: "Find All",
            data: result.recordset // Lấy dữ liệu từ recordset
        });
    } catch (error) {
        console.error(error); // Log lỗi
        res.status(500).json({
            status: 400,
            message: "Lỗi truy xuất",
            data: []
        });
    }
});
app.get('/ListNoiDi', async (req, res) => {
    try {
        const pool = await conn; // Kết nối tới cơ sở dữ liệu
        
        const sqlString = "SELECT noidi FROM vemaybay";

        // Thực hiện truy vấn
        const result = await pool.request().query(sqlString);

        // Kiểm tra kết quả và trả về phản hồi
        res.json({
            status: 200,
            message: "Find All",
            data: result.recordset // Lấy dữ liệu từ recordset
        });
    } catch (error) {
        console.error(error); // Log lỗi
        res.status(500).json({
            status: 400,
            message: "Lỗi truy xuất",
            data: []
        });
    }
});
app.get('/ListNoiDen', async (req, res) => {
    try {
        const pool = await conn; // Kết nối tới cơ sở dữ liệu
        
        const sqlString = "SELECT noiden FROM vemaybay";

        // Thực hiện truy vấn
        const result = await pool.request().query(sqlString);

        // Kiểm tra kết quả và trả về phản hồi
        res.json({
            status: 200,
            message: "Find All",
            data: result.recordset // Lấy dữ liệu từ recordset
        });
    } catch (error) {
        console.error(error); // Log lỗi
        res.status(500).json({
            status: 400,
            message: "Lỗi truy xuất",
            data: []
        });
    }
});
app.get('/ListHangBay', async (req, res) => {
    try {
        const pool = await conn; // Kết nối tới cơ sở dữ liệu
        
        const sqlString = "SELECT tenhangbay FROM hangbay";

        // Thực hiện truy vấn
        const result = await pool.request().query(sqlString);

        // Kiểm tra kết quả và trả về phản hồi
        res.json({
            status: 200,
            message: "Find All",
            data: result.recordset // Lấy dữ liệu từ recordset
        });
    } catch (error) {
        console.error(error); // Log lỗi
        res.status(500).json({
            status: 400,
            message: "Lỗi truy xuất",
            data: []
        });
    }
});
app.get('/ListTenGhe', async (req, res) => {
    try {
        const pool = await conn; // Kết nối tới cơ sở dữ liệu
        
        const sqlString = "SELECT DISTINCT tenghe FROM vemaybay";

        // Thực hiện truy vấn
        const result = await pool.request().query(sqlString);

        // Kiểm tra kết quả và trả về phản hồi
        res.json({
            status: 200,
            message: "Find All",
            data: result.recordset // Lấy dữ liệu từ recordset
        });
    } catch (error) {
        console.error(error); // Log lỗi
        res.status(500).json({
            status: 400,
            message: "Lỗi truy xuất",
            data: []
        });
    }
});
app.get('/ListHanhLy', async (req, res) => {
    try {
        const pool = await conn; // Kết nối tới cơ sở dữ liệu
        
        const sqlString = "SELECT khoiluong,giatien FROM hanhly";

        // Thực hiện truy vấn
        const result = await pool.request().query(sqlString);

        // Kiểm tra kết quả và trả về phản hồi
        res.json({
            status: 200,
            message: "Find All",
            data: result.recordset // Lấy dữ liệu từ recordset
        });
    } catch (error) {
        console.error(error); // Log lỗi
        res.status(500).json({
            status: 400,
            message: "Lỗi truy xuất",
            data: []
        });
    }
});
app.post('/login', async (req, res) => {
    const { taikhoan, matkhau } = req.body;

    // Ghi log tài khoản và mật khẩu nhận được
    console.log("Đăng nhập với tài khoản:", taikhoan, "và mật khẩu:", matkhau);

    try {
        const pool = await conn;
        const sqlString = "SELECT taikhoan, matkhau FROM taikhoan WHERE taikhoan = @taikhoan";

        // Chỉ cần lấy tài khoản để so sánh mật khẩu sau
        const result = await pool.request()
            .input('taikhoan', sql.VarChar, taikhoan)
            .query(sqlString);

        if (result.recordset.length > 0) {
            const storedPassword = result.recordset[0].matkhau; // Lấy mật khẩu từ bản ghi

            // So sánh mật khẩu nếu mật khẩu được mã hóa
            if (storedPassword === matkhau) { // Nếu không mã hóa
                res.json({
                    status: 200,
                    message: "Đăng nhập thành công",
                    data: result.recordset
                });
            } else {
                res.status(401).json({
                    status: 401,
                    message: "Tài khoản hoặc mật khẩu không đúng",
                    data: []
                });
            }
        } else {
            res.status(401).json({
                status: 401,
                message: "Tài khoản hoặc mật khẩu không đúng",
                data: []
            });
        }
    } catch (error) {
        console.error("Lỗi truy xuất:", error);
        res.status(500).json({
            status: 500,
            message: "Lỗi truy xuất",
            data: []
        });
    }
});
app.post('/insert', async (req, res) => {
    const {tenkhachhang,taikhoan, matkhau } = req.body;

    // Ghi log thông tin nhận được
    console.log("Chèn tài khoản:", taikhoan, "Tên khách hàng:", tenkhachhang);

    try {
        const pool = await conn;

        // Kiểm tra xem tài khoản đã tồn tại chưa trong bảng taikhoan
        const checkAccount = await pool.request()
            .input('taikhoan', sql.VarChar, taikhoan)
            .query("SELECT taikhoan FROM taikhoan WHERE taikhoan = @taikhoan");

        if (checkAccount.recordset.length > 0) {
            return res.status(400).json({
                status: 400,
                message: "Tài khoản đã tồn tại",
                data: []
            });
        }

        // Lấy giá trị makh lớn nhất
        const maxMakhResult = await pool.request().query("SELECT ISNULL(MAX(makh), 0) AS maxMakh FROM khachhang");
        const newMakh = maxMakhResult.recordset[0].maxMakh + 1;

        // Chèn thông tin vào bảng khachhang
        const insertCustomerQuery = `
            INSERT INTO khachhang (makh,tenkhachhang)
            VALUES (@makh,@tenkhachhang)
        `;
        await pool.request()
            .input('makh', sql.Int, newMakh)
            .input('tenkhachhang', sql.NVarChar, tenkhachhang)
            .query(insertCustomerQuery);


            // Chèn tài khoản vào bảng taikhoan
        const insertAccountQuery = `
        INSERT INTO taikhoan (makh,taikhoan, matkhau)
        VALUES (@makh,@taikhoan, @matkhau)
        `;
        await pool
          .request()
          .input("makh", sql.Int, newMakh)
          .input("taikhoan", sql.VarChar, taikhoan)
          .input("matkhau", sql.VarChar, matkhau)
          .query(insertAccountQuery);

        res.json({
            status: 201,
            message: "Tài khoản và thông tin khách hàng đã được tạo thành công",
            data: { taikhoan, tenkhachhang }
        });
    } catch (error) {
        console.error("Lỗi truy xuất:", error);
        res.status(500).json({
            status: 500,
            message: "Lỗi truy xuất",
            data: []
        });
    }
});





// các route
app.get('/diadiemks',async function(req,res){
    var pool = await conn ;
    var sqlString = "select * from diadiemkhachsan";
    return await pool.request().query(sqlString,function(err,data){
       if ( data.recordset.length > 0)
       {
        res.send(data.recordset);
       }else{
        res.send(null);
       }
    });
})
app.get('/phong',async function(req,res){
    var pool = await conn ;
    var sqlString = "select * from phongkhachsan";
    return await pool.request().query(sqlString,function(err,data){
        if ( data.recordset.length > 0)
            {
             res.send(data.recordset);
            }else{
             res.send(null);
            }
    });
})
app.get('/khachsan',async function(req,res){
    var pool = await conn ;
    var sqlString = "select * from khachsan";
    return await pool.request().query(sqlString,function(err,data){
        if ( data.recordset.length > 0)
            {
             res.send(data.recordset);
            }else{
             res.send(null);
            }
    });
})
app.get('/diadiemks/:id',async function (req,res) {
    var id = req.params.id;
    var pool = await conn;
    var sqlString="select * from diadiemkhachsan where madiadiemks = "+id;
    return await pool.request().query(sqlString,function(err,data){
        if ( data.recordset.length > 0)
            {
             res.send(data.recordset);
            }else{
             res.send(null);
            }
    })
})

// Khởi động server
app.listen(3009, () => {
    console.log('Server is running on port 3009');
});

// Xuất app và kết nối
module.exports = {
    app,
    conn,
    sql
};