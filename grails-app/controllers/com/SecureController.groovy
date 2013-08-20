package com

import org.springframework.security.access.annotation.Secured

@Secured(['ROLE_ADMIN'])
class SecureController {

   // @Secured(['ROLE_ADMIN'])
    def index = {
        render 'Secure access only'
    }
}
