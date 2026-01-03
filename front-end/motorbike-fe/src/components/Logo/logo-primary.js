import React from "react";

const Logo = ({ variant = "primary", height = 40 }) => {
  const isDark = variant === "white";
  const mainColor = "#FF3131";
  const secondaryColor = isDark ? "#FFFFFF" : "#2D3748";
  const textColor = isDark ? "#FFFFFF" : "#1A202C";
  const sloganColor = isDark ? "#CBD5E0" : "#718096";

  return (
    <div
      style={{
        display: "flex",
        alignItems: "center",
        height: `${height}px`,
        userSelect: "none",
        overflow: "visible",
      }}
    >
      <svg
        width={height * 2}
        height={height}
        viewBox="0 0 200 100"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <g>
          <circle
            cx="50"
            cy="70"
            r="18"
            stroke={secondaryColor}
            strokeWidth="6"
          />
          <circle
            cx="50"
            cy="70"
            r="10"
            fill={secondaryColor}
            fillOpacity="0.3"
          />
          <circle cx="50" cy="70" r="3" fill={secondaryColor} />
        </g>

        <g>
          {/* Lốp xe */}
          <circle
            cx="150"
            cy="70"
            r="18"
            stroke={secondaryColor}
            strokeWidth="6"
          />

          <circle
            cx="150"
            cy="70"
            r="10"
            fill={secondaryColor}
            fillOpacity="0.3"
          />
          <circle cx="150" cy="70" r="3" fill={secondaryColor} />
        </g>
        <path
          d="M60 75 L100 70 C105 69 105 65 100 65 L65 68 Z"
          fill={secondaryColor}
        />
        <path
          d="M50 70 L90 70 L110 55 L130 55 L145 70"
          fill="none"
          stroke={secondaryColor}
          strokeWidth="4"
          strokeLinecap="round"
          strokeLinejoin="round"
        />
        <path
          d="M35 55 
       C 35 45, 45 45, 55 45 
       L 90 45 
       Q 110 45, 115 55 
       L 125 35 
       L 135 35 
       L 130 55 
       L 110 65 
       L 70 65 
       L 55 60 Z"
          fill={mainColor}
          stroke={mainColor}
          strokeWidth="2"
          strokeLinejoin="round"
        />
        <path
          d="M50 45 L95 45 Q 100 45, 100 50 L 50 50 Q 45 50, 45 45 Z"
          fill={secondaryColor}
        />
        <path
          d="M135 35 L 150 70"
          stroke={secondaryColor}
          strokeWidth="3"
          strokeLinecap="round"
        />
        <path
          d="M130 35 L 125 30 L 140 30"
          stroke={secondaryColor}
          strokeWidth="3"
          strokeLinecap="round"
          fill="none"
        />
        <path d="M135 35 L140 35 L140 42 Z" fill="#FFD700" />{" "}
        <path
          d="M138 60 Q 150 50, 162 60"
          stroke={mainColor}
          strokeWidth="3"
          fill="none"
        />
      </svg>

      <div
        style={{
          marginLeft: "10px",
          display: "flex",
          flexDirection: "column",
          justifyContent: "center",
          lineHeight: 1,
        }}
      >
        <div
          style={{
            fontFamily: "'Arial Black', Gadget, sans-serif",
            fontSize: `${height * 0.5}px`,
            fontWeight: "900",
            color: textColor,
            letterSpacing: "-1px",
            fontStyle: "italic",
            display: "flex",
            alignItems: "baseline",
          }}
        >
          MOTO<span style={{ color: mainColor }}>CARE</span>
        </div>
        <div
          style={{
            fontFamily: "sans-serif",
            fontSize: `${height * 0.21}px`,
            color: sloganColor,
            fontWeight: "bold",
            letterSpacing: "0.5px",
            textTransform: "uppercase",
            marginTop: "4px",
          }}
        >
          Chuyên gia sửa chữa
        </div>
      </div>
    </div>
  );
};

export default Logo;
