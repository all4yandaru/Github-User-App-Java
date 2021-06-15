package com.project.githubapp.service;

import com.google.gson.annotations.SerializedName;

public class GithubResponse{

	@SerializedName("gists_url")
	private String gistsUrl;

	@SerializedName("repos_url")
	private String reposUrl;

	@SerializedName("following_url")
	private String followingUrl;

	@SerializedName("twitter_username")
	private String twitterUsername;

	@SerializedName("bio")
	private Object bio;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("login")
	private String login;

	@SerializedName("type")
	private String type;

	@SerializedName("blog")
	private String blog;

	@SerializedName("subscriptions_url")
	private String subscriptionsUrl;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("site_admin")
	private boolean siteAdmin;

	@SerializedName("company")
	private String company;

	@SerializedName("id")
	private int id;

	@SerializedName("public_repos")
	private int publicRepos;

	@SerializedName("gravatar_id")
	private String gravatarId;

	@SerializedName("email")
	private Object email;

	@SerializedName("organizations_url")
	private String organizationsUrl;

	@SerializedName("hireable")
	private Object hireable;

	@SerializedName("starred_url")
	private String starredUrl;

	@SerializedName("followers_url")
	private String followersUrl;

	@SerializedName("public_gists")
	private int publicGists;

	@SerializedName("url")
	private String url;

	@SerializedName("received_events_url")
	private String receivedEventsUrl;

	@SerializedName("followers")
	private int followers;

	@SerializedName("avatar_url")
	private String avatarUrl;

	@SerializedName("events_url")
	private String eventsUrl;

	@SerializedName("html_url")
	private String htmlUrl;

	@SerializedName("following")
	private int following;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private String location;

	@SerializedName("node_id")
	private String nodeId;

	public String getGistsUrl(){
		return gistsUrl;
	}

	public String getReposUrl(){
		return reposUrl;
	}

	public String getFollowingUrl(){
		return followingUrl;
	}

	public String getTwitterUsername(){
		return twitterUsername;
	}

	public Object getBio(){
		return bio;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getLogin(){
		return login;
	}

	public String getType(){
		return type;
	}

	public String getBlog(){
		return blog;
	}

	public String getSubscriptionsUrl(){
		return subscriptionsUrl;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public boolean isSiteAdmin(){
		return siteAdmin;
	}

	public String getCompany(){
		return company;
	}

	public int getId(){
		return id;
	}

	public int getPublicRepos(){
		return publicRepos;
	}

	public String getGravatarId(){
		return gravatarId;
	}

	public Object getEmail(){
		return email;
	}

	public String getOrganizationsUrl(){
		return organizationsUrl;
	}

	public Object getHireable(){
		return hireable;
	}

	public String getStarredUrl(){
		return starredUrl;
	}

	public String getFollowersUrl(){
		return followersUrl;
	}

	public int getPublicGists(){
		return publicGists;
	}

	public String getUrl(){
		return url;
	}

	public String getReceivedEventsUrl(){
		return receivedEventsUrl;
	}

	public int getFollowers(){
		return followers;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public String getEventsUrl(){
		return eventsUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public int getFollowing(){
		return following;
	}

	public String getName(){
		return name;
	}

	public String getLocation(){
		return location;
	}

	public String getNodeId(){
		return nodeId;
	}

	@Override
 	public String toString(){
		return 
			"GithubResponse{" + 
			"gists_url = '" + gistsUrl + '\'' + 
			",repos_url = '" + reposUrl + '\'' + 
			",following_url = '" + followingUrl + '\'' + 
			",twitter_username = '" + twitterUsername + '\'' + 
			",bio = '" + bio + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",login = '" + login + '\'' + 
			",type = '" + type + '\'' + 
			",blog = '" + blog + '\'' + 
			",subscriptions_url = '" + subscriptionsUrl + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",site_admin = '" + siteAdmin + '\'' + 
			",company = '" + company + '\'' + 
			",id = '" + id + '\'' + 
			",public_repos = '" + publicRepos + '\'' + 
			",gravatar_id = '" + gravatarId + '\'' + 
			",email = '" + email + '\'' + 
			",organizations_url = '" + organizationsUrl + '\'' + 
			",hireable = '" + hireable + '\'' + 
			",starred_url = '" + starredUrl + '\'' + 
			",followers_url = '" + followersUrl + '\'' + 
			",public_gists = '" + publicGists + '\'' + 
			",url = '" + url + '\'' + 
			",received_events_url = '" + receivedEventsUrl + '\'' + 
			",followers = '" + followers + '\'' + 
			",avatar_url = '" + avatarUrl + '\'' + 
			",events_url = '" + eventsUrl + '\'' + 
			",html_url = '" + htmlUrl + '\'' + 
			",following = '" + following + '\'' + 
			",name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			",node_id = '" + nodeId + '\'' + 
			"}";
		}
}