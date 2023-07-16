import React from "react";
import PropTypes from "prop-types";

export const LocalPharmacy = ({ className, height = "24", width = "24", style = {}, fill = "#F47738", onClick = null }) => {
  return (
    <svg width={width} height={height} className={className} onClick={onClick} style={style} viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
      <g clip-path="url(#clip0_1974_11169)">
        <path d="M21 5H18.36L19.5 1.86L17.15 1L15.69 5H3V7L5 13L3 19V21H21V19L19 13L21 7V5ZM16 14H13V17H11V14H8V12H11V9H13V12H16V14Z" fill={fill} />
      </g>
      <defs>
        <clipPath id="clip0_1974_11169">
          <rect width="24" height="24" fill="white" />
        </clipPath>
      </defs>
    </svg>
  );
};


