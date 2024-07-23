//
//  ActionButton.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 20.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ActionButton: View {
    let title: String
    var enabled: Bool = true
    let height: CGFloat = 56
    let horizontalMargin: CGFloat = 16
    let action: ()-> Void
    
    init(title: String, enabled: Bool, action: @escaping () -> Void) {
        self.title = title
        self.enabled = enabled
        self.action = action
    }
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.tint)
                .opacity(enabled ? 1.0: 0.5)
            
            Text(title)
                .foregroundColor(.actionText)
        }
        .frame(maxWidth: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/, minHeight: height)
        .padding(EdgeInsets(top: 0, leading: horizontalMargin, bottom: 0, trailing: horizontalMargin))
        .onTapGesture {
            action()
        }
    }
}

#Preview {
    ActionButton(title: "Button Title", enabled: true){}
}
