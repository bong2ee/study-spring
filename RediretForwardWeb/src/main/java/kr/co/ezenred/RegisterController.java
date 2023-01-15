package kr.co.ezenred;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {

   @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
   public String register() {
      return "registerForm";
   }
   
   @RequestMapping(value = "/save")
   public String save(User user, Model m) throws Exception {
      if(!isValid(user)) {
         String msg = URLEncoder.encode("잘못된 ID", "utf-8");
         m.addAttribute("msg", msg);
//         return "redirect:/register/add?msg="+msg;      // URL
         return "forward:/register/add";      // URL
      }
      return "registerInfo";
   }

   private boolean isValid(User user) {
      // TODO Auto-generated method stub
      return false;
   }
}