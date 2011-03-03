import uk.co.webflow.User
class BootStrap {

    def init = { servletContext ->
		User.build(username: 'jack', password: 'password', credits: 0, enabled:true).save()
		User.build(username: 'james', password: 'password', credits: 1, enabled:true).save()
		User.build(username: 'sarah', password: 'password', credits: 1, enabled:true, email: 'sarah@mailinator.com').save()
    }
    def destroy = {
    }
}
