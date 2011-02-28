class HarassController < ApplicationController
      def index
      	  time = Time.now
	  @time = time
	  @who = `who`
      end
end
