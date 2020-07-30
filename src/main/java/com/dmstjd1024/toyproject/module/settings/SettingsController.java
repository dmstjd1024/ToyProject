package com.dmstjd1024.toyproject.module.settings;

import com.dmstjd1024.toyproject.module.account.AccountRepository;
import com.dmstjd1024.toyproject.module.order.Orders;
import com.dmstjd1024.toyproject.module.order.OrdersRepository;
import com.dmstjd1024.toyproject.module.product.Product;
import com.dmstjd1024.toyproject.module.product.ProductRepository;
import com.dmstjd1024.toyproject.module.zone.Zone;
import com.dmstjd1024.toyproject.module.zone.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/settings")
public class SettingsController {

    private final AccountRepository accountRepository;
    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;
    private final ZoneRepository zoneRepository;

    @InitBinder("passwordForm")
    public void passwordFormInitBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new PasswordFormValidator());
    }

    //    나의 주문
    @GetMapping("/order")
    public String userOrderList(Model model, Principal principal){

        Long accountId = accountRepository.findByNickname(principal.getName()).getId();

        List<Orders> ordersList = ordersRepository.findByAccountId(accountId);

        model.addAttribute(ordersList);

        return "settings/order";
    }

    @GetMapping("/order/cancel")
    public String userOrderCancel(){

        return "settings/order-cancel";
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
    public String userSettings(Model model){

        return "settings/user";
    }

    @GetMapping("/user/withdraw")
    public String userWithdraw(){

        return "settings/withdraw";
    }

    @GetMapping("/changePassword")
    public String passwordChangeForm(Model model){
        model.addAttribute(new PasswordForm());
        return "settings/change-password";
    }

    @PostMapping("/changePassword")
    public String passwordChange(Model model, @Valid PasswordForm passwordForm, Errors errors){

        if(errors.hasErrors()){
            return "settings/change-password";
        }
        
        return "redirect:/settings/user";
    }

}
