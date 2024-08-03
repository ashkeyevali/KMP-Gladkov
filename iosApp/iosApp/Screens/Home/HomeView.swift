//
//  HomeView.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 28.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct HomeView: View {
    let viewState: HomeViewState
    let eventHandler: (HomeEvent) -> Void
    
    var body: some View {
        ZStack {
            VStack {
                Spacer().frame(height: 16)
                
                HStack(alignment: .top) {
                    Spacer().frame(width: 16)
                    AsyncImage(url: URL(string: viewState.avatarUrl), content:  { image in
                            image
                                .resizable()
                                .aspectRatio(contentMode: /*@START_MENU_TOKEN@*/.fill/*@END_MENU_TOKEN@*/)
                                .frame(width: 56, height: 56)
                        }, placeholder: {
                            ProgressView()
                        })
                    .clipShape(Circle())
                    .frame(width: 56, height: 56)
            
                    
                    Spacer().frame(width: 20)
                    
                    VStack(alignment: .leading){
                        Text(viewState.status)
                            .foregroundColor(Color.textPrimary.opacity(0.5))
                            .font(.system(size: 12))
                        Spacer().frame(height: 4)
                        
                        Text(viewState.username)
                            .foregroundColor(Color.textPrimary)
                            .fontWeight(/*@START_MENU_TOKEN@*/.bold/*@END_MENU_TOKEN@*/)
                            .font(.system(size: 12))
                        
                    }
                    .onTapGesture {
                        eventHandler(HomeEvent.UserProfileClicked())
                    }
                    
                    Spacer()
                    
                }
                Spacer()
            }
            .frame(maxWidth: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/, maxHeight: .infinity)
            .background(Color.backgroundPrimary)
        }
    }
}

#Preview {
    HomeView(viewState: HomeViewState(username: "ashkeyevli", avatarUrl: "https://64.media.tumblr.com/95577ba2c2f28974f84eac47bec1db09/f6ae847d6732005f-f3/s1280x1920/65b40b69f3788e6618975e9dbb5c7aed8495eef6.jpg", status: "morning"), eventHandler: {event in }).background(Color.backgroundPrimary)
}
