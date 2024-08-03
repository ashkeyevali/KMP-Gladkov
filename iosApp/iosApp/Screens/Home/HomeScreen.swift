//
//  HomeScreen.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 23.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct HomeScreen: View {
    @State private var isProfilePresented = false
    private let homeViewModel = HomeViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(homeViewModel.viewStates())) { viewState in
            HomeView(viewState: viewState) { event in
                homeViewModel.obtainEvent(viewEvent: event)
                
            }
            
        }.sheet(isPresented: $isProfilePresented){ Text("Hello, Profile")}
            .onReceive(sharedPublisher(homeViewModel.viewActions())) { action in
                switch(action) {
                case HomeAction.ShowUserProfile(): isProfilePresented = true
                default: break
                }
                
            }
    }
}

#Preview {
    HomeScreen()
}
