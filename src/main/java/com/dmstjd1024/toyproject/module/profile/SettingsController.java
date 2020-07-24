package com.dmstjd1024.toyproject.module.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/settings/**")
public class SettingsController {

//    나의 주문

    @GetMapping("/purchase")
    public String userPurchaseList(){

        return "settings/purchase";
    }

    @GetMapping("/purchase/cancel")
    public String userPurchaseCancel(){

        return "settings/purchase-cancel";
    }

//    나의 문의
    @GetMapping("/contact")
    public String userContact(){

        return "settings/contact";
    }

    @GetMapping("/contact/create")
    public String userContactCreate(){

        return "settings/contact";
    }

    @GetMapping("/contact/reviews")
    public String userReviews(){

        return "settings/reviews";
    }

//    쿠폰
    @GetMapping("/coupon")
    public String coupon(){

        return "settings/coupon";
    }

//  나의 정보
    @GetMapping("/user")
    public String userSettings(){

        return "settings/user";
    }

    @GetMapping("/user/withdraw")
    public String userWithdraw(){

        return "settings/withdraw";
    }

    @GetMapping("/address")
    public String userAddress(){

        return "settings/address";
    }


}
