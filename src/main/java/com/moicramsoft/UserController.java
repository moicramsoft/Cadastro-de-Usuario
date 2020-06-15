package com.moicramsoft;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {
	@Autowired
	private UserRepository userRepository;
    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "addUser";
    }
    @RequestMapping("/")
	public String UserListar(@Valid User user,BindingResult result,Model ModelAndView) {
		ModelAndView.addAttribute("users", userRepository.findAll());
		return "index";
    }
		
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		//fiz assim para evitar com que o cache grave o mesms dados se o usuario pressionar F5
            return "redirect:/";
        } 
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Usuário Invalido:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
      BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        userRepository.deleteById(id);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/";
    }
	
}
