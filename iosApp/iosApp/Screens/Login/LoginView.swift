//
//  LoginView.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 16.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    var body: some View {
        VStack {
            
        }
        
        HStack {
            Spacer().frame(height: 36)
            Text("Login Now")
                .foregroundColor(.white)
                .fontWeight(.bold)
                .font(.system(size: 24))
            Text("Welcome back to PlayZone! Enter your email addres and your password to enjoy the latest features of PlayZone")
                .foregroundColor(.white.opacity(0.5))
                .fixedSize(horizontal: false, vertical: /*@START_MENU_TOKEN@*/true/*@END_MENU_TOKEN@*/)
                .multilineTextAlignment(.center)
                .padding(EdgeInsets(top: 16, leading: 30, bottom: 30, trailing: 16))
        }
        
        
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }
}

#Preview {
    LoginView()
}
