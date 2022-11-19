package com.example.veggiesetmall.controller;

import com.example.veggiesetmall.domain.Member;
import com.example.veggiesetmall.domain.item.Item;
import com.example.veggiesetmall.service.ItemService;
import com.example.veggiesetmall.service.MemberService;
import com.example.veggiesetmall.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model) {

        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam("memberId") Long memberId,  // memberId는 front html의 name 속성값
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count) {
        
        orderService.order(memberId, itemId, count);
        return "redirect:/orders";

    }




}
