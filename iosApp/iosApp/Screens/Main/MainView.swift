//
//  MainView.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 23.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct MainView: View {
    var body: some View {
        TabView {
            HomeScreen().tabItem { Label("Home", systemImage: "house") }
            SearchScreen().tabItem { Label("Search", systemImage: "magnifyingglass") }
            EventsScreen().tabItem { Label("Events", systemImage: "persone.fill")}
            VideosScreen().tabItem { Label("Videos", systemImage: "video")}
        }
    }
}

#Preview {
    MainView()
}
