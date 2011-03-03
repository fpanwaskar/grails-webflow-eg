package uk.co.webflow

class SearchController {

    def index = { 
		redirect(action: "usersearch")
	}
	
	def usersearchFlow = {
		enterSearch {
			on("search") {
				log.debug "Started search flow with criteria ${params?.username}"
				
				flow.userSearchCriteria = [username: params?.username]
				
				// capture criteria check user state
			}.to("registerUser")
		}
		
		registerUser {
			
		}
	}
}
