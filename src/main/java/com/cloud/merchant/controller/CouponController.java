package com.cloud.merchant.controller;


import com.cloud.dto.merchant.CouponDTO;
import com.cloud.merchant.service.ICouponService;
import com.cloud.utils.json.JSONResult;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final ICouponService couponService;

    public CouponController(ICouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    public JSONResult addCoupon(@RequestBody CouponDTO dto){
        return JSONResult.ok(dto);
    }

    @PutMapping
    public JSONResult updCoupon(@RequestBody CouponDTO dto){
        return JSONResult.ok(dto);
    }

    @DeleteMapping("/{cid}")
    public JSONResult delCoupon(@PathVariable Long cid){
        return JSONResult.ok(cid);
    }

    @GetMapping("/{page}/{size}")
    public JSONResult getCoupon(@PathVariable Integer page,@PathVariable Integer size){
        return JSONResult.ok(page+""+size);
    }

    @GetMapping("/{cid}")
    public JSONResult getCategoryByCouponId(@PathVariable Long cid){
        return JSONResult.ok(cid);
    }
}
