/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
* Type here a brief description of the class.
*
* @author lucas.regio Lucas Regio 
* @since 2018-11-30
*/

	@SuppressWarnings("deprecation")
	@RelationshipEntity(type="PLAYED_IN")
	public class Role {
	    @GraphId   private Long id;
	    
	    /**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		private String title;
		
		
		
	    /**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}
		
		
		
		/**
		 * @return the actor
		 */
		public Actor getActor() {
			return actor;
		}
		/**
		 * @param actor the actor to set
		 */
		public void setActor(Actor actor) {
			this.actor = actor;
		}
		/**
		 * @return the movie
		 */
		public Movie getMovie() {
			return movie;
		}
		/**
		 * @param movie the movie to set
		 */
		public void setMovie(Movie movie) {
			this.movie = movie;
		}
		@StartNode private Actor actor;
	    @EndNode   private Movie movie;
	}

	


