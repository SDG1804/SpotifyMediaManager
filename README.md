# week3project

## Problem Domain
The project domain that our group is planning on focusing on is media management. Our group plans on making a music 
recommendation and management tool for Spotify users.

Spotify has an API that allows you to check out a user's profile, playlists, saved tracks, followed artists, 
and many other features. It also allows you to manage their account such as adding new items to their playlists and
controlling what they are currently listening to.

We plan on using this tool to create an application that functions as a media manager. Users will be able to control
their spotify accounts as well as get new recommendations based on their profile as well as be able to check out their
friend's profiles and what music their primarily listen to. We are planning on using the user's information and use
known algorithms to find similar songs, artists and genres (currently we are considering cosine similarity).

## API Documentation
https://developer.spotify.com/documentation/web-api

## API Usage
We used Postman to test out the API. We first created a token for us to use and then used the token to access things
like artists and songs. The screenshots of our progress is below: 

<img width="1436" alt="Screen Shot 2023-09-30 at 9 28 33 PM" src="https://github.com/Avi04w/week3project/assets/78369627/f3fe6c09-93fe-477d-84bc-c56fac5884c1">
<img width="1440" alt="Screen Shot 2023-09-30 at 9 32 42 PM" src="https://github.com/Avi04w/week3project/assets/78369627/30d12285-fca0-439f-a98e-cacc1dcfc9c0">
<img width="1013" alt="Screenshot 2023-10-01 at 8 26 31 PM" src="https://github.com/Avi04w/week3project/assets/78369627/9d79c79c-0340-42f5-946c-d5a825f14cfc">

## Java Code
We created an example of an API call with java, creating an Artist object.

The example shown below is when we call the information for the artist "Pitbull".
You can find our code in the src folder of this repository.

<img src="/Users/aviwalia/Documents/Screenshot 2023-10-01 at 8.56.10 PM.png"/>

## Technical Problems
- We are a bit unsure of how to create the recommendation tool. How are we going to implement the cosine similarity
(or any other tool for finding similar objects) into Java?
