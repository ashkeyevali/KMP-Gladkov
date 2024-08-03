//
//  SearchView.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 30.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct SearchView: View {
    let viewState: SearchViewState
    let eventHandler: (SearchEvent) -> Void
    
    var body: some View {
        ZStack {
            VStack {
                Spacer().frame(height: 26)
                CommonTextField(hint: "Search Game", enabled: true, isSecure: false) { query in
                    eventHandler(SearchEvent.QueryChanged(query: query))
                    
                }
                
                Spacer().frame(height: 16)
                ScrollView {
                    VStack {
                        ForEach(viewState.games, id: \.id) { game in
                            VStack(alignment: .leading){
                            Text(game.title)
                                .foregroundColor(Color.textPrimary)
                                .padding(EdgeInsets(top: 8, leading: 16, bottom: 8, trailing: 15))}
                        }
                    }
                }
                
            }
            
        }
        .frame(width: .infinity, height: .infinity)
        .background(Color.backgroundPrimary)
        }
}

#Preview {
    SearchView(viewState: SearchViewState(query: "", games: Array<Game>())) {
        event in
    }
}
