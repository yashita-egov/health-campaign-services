import React from "react";
import PropTypes from "prop-types";

export const CompareArrows = ({ className, height = "24", width = "24", style = {}, fill = "#F47738", onClick = null }) => {
  return (
    <svg width={width} height={height} className={className} onClick={onClick} style={style} viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
      <g clip-path="url(#clip0_105_241)">
        <path d="M9.01 14H2V16H9.01V19L13 15L9.01 11V14ZM14.99 13V10H22V8H14.99V5L11 9L14.99 13Z" fill={fill} />
      </g>
      <defs>
        <clipPath id="clip0_105_241">
          <rect width="24" height="24" fill="white" />
        </clipPath>
      </defs>
    </svg>
  );
};


