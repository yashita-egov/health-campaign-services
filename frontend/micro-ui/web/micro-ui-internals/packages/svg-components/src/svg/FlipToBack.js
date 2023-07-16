import React from "react";
import PropTypes from "prop-types";

export const FlipToBack = ({ className, height = "24", width = "24", style = {}, fill = "#F47738", onClick = null }) => {
  return (
    <svg width={width} height={height} className={className} onClick={onClick} style={style} viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
      <g clip-path="url(#clip0_105_433)">
        <path
          d="M9 7H7V9H9V7ZM9 11H7V13H9V11ZM9 3C7.89 3 7 3.9 7 5H9V3ZM13 15H11V17H13V15ZM19 3V5H21C21 3.9 20.1 3 19 3ZM13 3H11V5H13V3ZM9 17V15H7C7 16.1 7.89 17 9 17ZM19 13H21V11H19V13ZM19 9H21V7H19V9ZM19 17C20.1 17 21 16.1 21 15H19V17ZM5 7H3V19C3 20.1 3.89 21 5 21H17V19H5V7ZM15 5H17V3H15V5ZM15 17H17V15H15V17Z"
          fill={fill}
        />
      </g>
      <defs>
        <clipPath id="clip0_105_433">
          <rect width="24" height="24" fill="white" />
        </clipPath>
      </defs>
    </svg>
  );
};


