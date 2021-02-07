package com.pgk.delivery.Shop.Controller;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Shop.Pojo.Commodity;
import com.pgk.delivery.Shop.Service.ShopService;
import com.pgk.delivery.Util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService service;


    @RequestMapping("/queryAll.do")
    public Result<?> queryAll(int pageNum, int pageSize, HttpServletRequest request, HttpServletResponse response) {
        int accountLimit = (int) request.getAttribute("accountLimit");
        if (accountLimit == 1) {
            Result<?> shops = service.queryAll(pageNum, pageSize);
            return shops;
        } else {
            response.setStatus(403);
            return null;
        }
    }

    @RequestMapping("/queryByName.do")
    public Result<?> queryByName(String shopName, int pageNum, int pageSize, HttpServletRequest request, HttpServletResponse response) {
        int accountLimit = (int) request.getAttribute("accountLimit");
        if (accountLimit == 1) {
            Result<?> shop = service.queryByName(shopName, pageNum, pageSize);
            return shop;
        } else {
            response.setStatus(403);
            return null;
        }
    }

    @RequestMapping("/queryById.do")
    public Result<?> queryById(int shopId, HttpServletRequest request, HttpServletResponse response) {
        int accountLimit = (int) request.getAttribute("accountLimit");
        if (accountLimit == 1) {
            Result<?> shop = service.queryById(shopId);
            return shop;
        } else {
            response.setStatus(403);
            return null;
        }
    }

    @RequestMapping("/queryAllCommodity.do")
    public Result<?> queryAllCommodity(HttpServletRequest request, HttpServletResponse response,String commodityShopId) {
        int accountLimit = (int) request.getAttribute("accountLimit");
        if (accountLimit == 4 ||accountLimit == 3) {
            Result<?> commodity = service.queryAllCommodity(commodityShopId);
            return commodity;
        }
        else {
            response.setStatus(403);
            return null;
        }
    }

    /**
     * 每次添加商品时的种类选项查询
     * @return
     */
    @RequestMapping("/selectMenu.do")
    public Result<?> selectMenu (){
            Result<?> menu = service.selectMenu();
            return menu;
    }
    @RequestMapping("/addMenu.do")
    public Result<?> addMenu (String shopMenuName){
        Result<?> menu = service.addMenu(shopMenuName);
        return menu;
    }


    @RequestMapping("/commodityAdd.do")
    public Result<?> commodityAdd (@RequestBody Commodity commodity){
       Result<?> msg = service.commodityAdd(commodity);
        return msg;
    }

    @RequestMapping("/commodityEdit.do")
    public Result<?> commodityEdit (@RequestBody Commodity commodity){
        Result<?> msg = service.commodityEdit(commodity);
        return msg;
    }


    @RequestMapping("/queryShopName.do")
    public Result<?> queryShopName (int sellerId){
        Result<?> msg = service.queryShopName(sellerId);
        return msg;
    }


    @RequestMapping("/pictureDelete.do")
public Result<?> pictureDelete (String path){
        path = path.replace("http://localhost:8087/picture/","");
        path = "D:/IdeaProject/Delivery/src/main/resources/static/picture/"+path;
        File file = new File(path);
        if (file.exists()) {//文件是否存在
            if (file.delete()) {//存在就删了
                return Result.success();
            } else {
                return Result.fail();
            }
        } else {
            System.out.println("文件不存在");
            return Result.fail();
        }

    }

    @RequestMapping("/pictureAdd.do")
    public Result<?> pictureAdd (@RequestParam("picture") MultipartFile picture){
        String path ="D:/IdeaProject/Delivery/src/main/resources/static/picture";
        File filePath = new File(path);
        //如果目录不存在，创建目录
        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdir();
        }
        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));
        //新名字
        String fileName = UUIDUtils.getUUID()  + "." + type;
        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            //将文件在服务器的存储路径返回
            return Result.success("http://localhost:8087/picture/"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail();
        }

    }



    @RequestMapping("/delectCommodity.do")
    public Result<?> delectCommodity(int commodityId, HttpServletRequest request, HttpServletResponse response) {
        int accountLimit = (int) request.getAttribute("accountLimit");

        if (accountLimit == 4 || accountLimit == 3) {
            Result<?> commoditys = service.delectCommodity(commodityId);
            if (commoditys.getCode() == -1) {
                response.setStatus(500);
                return null;
            }
            return Result.success();
        } else {
            response.setStatus(403);
            return null;
        }
    }




}
