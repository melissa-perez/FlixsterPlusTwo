# Android Project 4 - *Flixster+2*

Submitted by: **Melissa Perez**

**Flixster+2** is a movie browsing app that allows users to browse the highest rated of the top rated movies of all-time.

Time spent: **15** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **Choose any endpoint on The MovieDB API except `now_playing`**
    - Chosen Endpoint: `top_rated`
- [x] **Make a request to your chosen endpoint and implement a RecyclerView to display all entries**
- [x] **Use Glide to load and display at least one image per entry**
- [x] **Click on an entry to view specific details about that entry using Intents**

The following **optional** features are implemented:

- [x] **Add another API call and RecyclerView that lets the user interact with different data.**
  - Chosen Endpoint: `popular`
- [x] **Add rounded corners to the images using the Glide transformations**
- [x] **Implement a shared element transition when user clicks into the details of a movie**

The following **additional** features are implemented:

- [x] Removed EndlessRecyclerAdapterScroller to save memory usage
  - Therefore, only the first page of top rated movies is loaded

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with LICEcap


## Notes

Describe any challenges encountered while building the app.

- Changing the styling for the extra features.
- Using fragment files and messing with the context(scrapped the fragment listener for this project)
- Incorrect build settings.

## License

    Copyright [2023] [Melissa Perez]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
