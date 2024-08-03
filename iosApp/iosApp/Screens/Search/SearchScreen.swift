//
//  SearchScreen.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 23.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct SearchScreen: View {
    private let searchViewModel = SearchViewModel()
    
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(searchViewModel.viewStates())) { viewState in SearchView(viewState: viewState) { event in
            searchViewModel.obtainEvent(viewEvent: event)
                
            }
        }
//        .onReceive(sharedPublisher(searchViewModel.viewActions()) {
//            
//        }
    }
}

#Preview {
    SearchScreen()
}
