//
//  Color+Custom.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 17.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension Color {
    static let textPrimary = Color("primaryTextColor")
    static let textSecondary = Color("secondaryTextColor")
    static let actionText = Color("actionTextColor")
    static let backgroundPrimary = Color("backgroundPrimaryColor")
    static let secondaryBackground = Color("secondaryBackgroundColor")
    static let tint = Color("tintColor")
    
    
    init(hex: UInt, alpha: Double = 1) {
          self.init(
              .sRGB,
              red: Double((hex >> 16) & 0xff) / 255,
              green: Double((hex >> 08) & 0xff) / 255,
              blue: Double((hex >> 00) & 0xff) / 255,
              opacity: alpha)
      }
}
