package marshi.owl.web.view.ticket

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * Copyright: CYBER AGENT. INC
 */
@Controller
class VueController {

    @GetMapping("/vue")
    fun vue(): String{
        return "vue"
    }

}